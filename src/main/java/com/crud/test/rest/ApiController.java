package com.crud.test.rest;





    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    // import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crud.test.rest.educationData.Edu;
import com.crud.test.rest.educationData.EduDAO;
import com.crud.test.rest.expData.Exp;
import com.crud.test.rest.expData.ExpDAO;
import com.crud.test.rest.languageData.language;
import com.crud.test.rest.languageData.languageDAO;
import com.crud.test.rest.profileData.Skill;
import com.crud.test.rest.profileData.SkillDAO;
import com.crud.test.rest.sellerData.*;

// import com.crud.test.rest.profileData.Seller;
// import com.crud.test.rest.profileData.SellerDAO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;




    @RestController

public class ApiController {
	
	@Autowired 
	private UserDAO eDAO;
	@Autowired
	private SellerDAO sDAO;
	@Autowired
	private SkillDAO skillDAO;
    @Autowired
	private EduDAO eduDAO;
	@Autowired
	private ExpDAO expDAO;
	@Autowired
	private languageDAO langDAO;
	
    //GetMapping
    @RequestMapping({"/Users","testing"})
	public List<User> findAll() {
		return eDAO.findAll();
	}


	@GetMapping("/Users/{id}")
	public User findById(@PathVariable int id) {
		return eDAO.findById(id);
	}

	
	@DeleteMapping("/Users/{id}")
	public String deleteById(@PathVariable int id) {
		return eDAO.deleteById(id)+" User(s) delete from the database";
	}
	
	//Get user's info from API and checks whether the email already exists in the database,
	//if already existed, throw errors else insert the user's info to the database as a new users.
	@PostMapping("/SignUp")
	public String save(@RequestBody User e) {
		try{
		return eDAO.save(e)+" User(s) saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

	//Get userID and update its role from User to Admin
	@PostMapping("/changeAdmin")
	public String updateRole(@RequestBody User e) {
		
		return eDAO.updateRole(e)+" User(s) Updated successfully";
	
	
	}

	//Get userID and update its role from Admin to User
	@PostMapping("/changeUser")
	public String updateRoleUser(@RequestBody User e) {
		
		return eDAO.updateRoleUser(e)+" User(s) Updated successfully";
	
	
	}


//Checks the whether the email & pw get from API exists inside database, if not matched throws an errors.
//If matched, run jwt token generator functions to get the jwt token and return it to API
    @PostMapping("/login")
	public User login(@RequestBody User e) {
	    try {

			return eDAO.login(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}

		
    
	}

//Gets email, and checks whether it mathces the email in database 
//if success, return all information about that users using email
	@PostMapping("/loginId")
	public User loginIdUser(@RequestBody User e) {
	    try {
			return eDAO.loginId(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}
	}
//Gets userID, and return all information of that users except password 
	@PostMapping("/UserId")
	public User UserId(@RequestBody User e) {
	    
			return eDAO.UserId(e);
		
	}

	//Gets userID and return all information about that users
	@PostMapping("/UserIdAdmin")
	public User UserIdAdmin(@RequestBody User e) {
	    
			return eDAO.UserIdAdmin(e);
		
	}


	@PostMapping("/test2")
	public String test2(@RequestHeader String auth) {
		System.out.println("printing the auth "+auth);
		return "Success";

	}


    //gets jwt token from API's headers ("Authorization") , decode it and checks & return whether it is expired
	@GetMapping("/auth")
	public String protectedEndpoint(@RequestHeader("Authorization") String jwt) {
    Jws<Claims> token = JWTGenerateValidateHMAC.parseJwt(jwt);
    Claims claims = token.getBody();

    boolean isExpired = JWTGenerateValidateHMAC.isTokenExpired(claims.getExpiration());
	boolean isValid = JWTGenerateValidateHMAC.isTokenValid(jwt, claims);

    if (isExpired || !isValid) {
        return "Unauthorized: Invalid or expired token";
    } else {
        // Return data or perform protected action
        return "Success: Valid token";
    }
}


//SELLER DATA

//Get all seller list in the database
@RequestMapping({"/sellerList"})
public List<Seller> findAll2() {
	return sDAO.findAll2();
}

//Gets seller's info and insert it into seller_table in database
@PostMapping("/seller")
	public String saveData(@RequestBody Seller s) {
		try{
		return sDAO.saveData(s)+" User(s) saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}
	
//Gets sellerID and return all information about that seller including state name
	@PostMapping("/findSellerData")
	public Seller findSellerData(@RequestBody Seller s) {
	   
			return sDAO.findSellerData(s);
		
	}

//Gets state name and return with stateID
	@PostMapping("/StateID")
	public Seller StateId(@RequestBody Seller s) {
	   
			return sDAO.StateID(s);
		
	}

//Gets userID and checks whether theres duplicated, if yes, throws Exception else return nothing
	@PostMapping("/check")
	public String validateData(@RequestBody Seller s) {
		
		return sDAO.validateData(s)+"ALREADY INSERTED";
	}

//Return the list of all Sellers
	@RequestMapping({"/Sellers"})
	public List<Seller> findAlls() {
		return sDAO.findAll();
	}

//Gets userID and return sellerID
	@PostMapping("/SellerID")
	public Seller SellerId(@RequestBody Seller s) {
	   
			return sDAO.SellerID(s);
		
	}


	////Skill
	
//gets skill Proficient Level and return skill Proficient ID
	@PostMapping("/SkillProfID")
	public Skill SkillProfId(@RequestBody Skill sk) {
			return skillDAO.SkillProfID(sk);
	}

//Return list of all skill
	@RequestMapping({"/Skills"})
	public List<Skill> findAllskill() {
		return skillDAO.findAll();
	}

//Get skill's information and insert into database 
	@PostMapping("/createSkill")
	public String saveSkill(@RequestBody Skill sk) {
		try{
		return skillDAO.saveSkill(sk)+" Skill saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

//Get sellerID and return with all skills info including skill proficient level
	@PostMapping("/findSkills")
	public List<Skill> findSkills(@RequestBody Skill sk) {
	   
			return skillDAO.findSkills(sk);
		
	}

//Get skill ID and delete it in database
	@PostMapping("/deleteSkill")
	public String deleteSkill(@RequestBody Skill sk) {
		
		return skillDAO.deleteSkill(sk)+" Skill deleted successfully";
		
	}

//Get new skill's information and update it 
	@PostMapping("/editSkill")
	public String editSkill(@RequestBody Skill sk) {
		
		return skillDAO.editSkill(sk)+" Skill edited successfully";
		
	
	}
	

	////Education

//Gets sellerID and return all education's info about that seller including qualification type
	@PostMapping("/findEduData")
	public List<Edu> findEduData(@RequestBody Edu ed) {
	   
			return eduDAO.findEduData(ed);
		
	}

//Return list of all qualification
	@RequestMapping({"/Qualifications"})
			public List<Edu> findAllEdu() {
				return eduDAO.findAll();
			}

//Gets qualification type and return qualification ID
	@PostMapping("/EduQualiID")
	public Edu EduQualiID(@RequestBody Edu ed) {
			return eduDAO.EduQualiID(ed);
	}


//Gets educaiton's info and insert it into database
	@PostMapping("/createEdu")
	public String saveEdu(@RequestBody Edu ed) {
		
		return eduDAO.saveEdu(ed)+" Education saved successfully";
		
	
	}

//Gets education ID and delete it from database
	@PostMapping("/deleteEducation")
	public String deleteEducation(@RequestBody Edu ed) {
		
		return eduDAO.deleteEducation(ed)+" Edu deleted successfully";
		
	}

//Get new education's information and update it 
	@PostMapping("/editEducation")
	public String editEducaiton(@RequestBody Edu ed) {
		
		return eduDAO.editEducation(ed)+" Edu edited successfully";

	}

////Experience

//Gets sellerID and return all experience's info about that seller including industry type
	@PostMapping("/findExpData")
	public List<Exp> findExpData(@RequestBody Exp xp) {
		
			return expDAO.findExpData(xp);
		
	}

//Return list of all industry type
	@RequestMapping({"/Industry"})
	public List<Exp> findAllExp() {
		return expDAO.findAll();
	}

//Gets industry type and return industryID
	@PostMapping("/ExpIndustryID")
	public Exp ExpIndustryID(@RequestBody Exp xp) {
			return expDAO.ExpIndustryID(xp);
	}

//Gets experience's info and insert it into database
	@PostMapping("/createExp")
	public String saveExp(@RequestBody Exp xp) {
		try{
		return expDAO.saveExp(xp)+" Experience saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

//Gets experience ID and delete it from database
	@PostMapping("/deleteExperience")
	public String deleteExperience(@RequestBody Exp xp) {
		
		return expDAO.deleteExperience(xp)+" Exp deleted successfully";
		
	}

//Get new experience's information and update it 
	@PostMapping("/editExperience")
	public String editExperience(@RequestBody Exp xp) {
		
		return expDAO.editExperience(xp)+" Exp edited successfully";
		
	
	}


////Language

//Gets sellerID and return all language's info about that seller including language proficient level
	@PostMapping("/findLanguages")
	public List<language> findLanguage(@RequestBody language l) {
		
			return langDAO.findLanguage(l);
		
	}

//Return list of all languages 
	@RequestMapping({"/Languages"})
	public List<language> findAlllanguage() {
		return langDAO.findAll();
	}

//Get language name and return its ID
	@PostMapping("/langTypeID")
	public language langTypeID(@RequestBody language l) {
			return langDAO.langTypeID(l);
	}

//Get language proficient level and return its ID
	@PostMapping("/langProfID")
	public language langProfID(@RequestBody language l) {
			return langDAO.langProfID(l);
	}

//Gets language's info and insert it into database
	@PostMapping("/createLang")
	public String saveLang(@RequestBody language l) {
		try{
		return langDAO.saveLang(l)+" Language saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

//Gets language ID and delete it from database
	@PostMapping("/deleteLang")
	public String deleteLang(@RequestBody language l) {
		
		return langDAO.deleteLang(l)+" Language deleted successfully";
		
	}

//Get new language's information and update it 
	@PostMapping("/editLang")
	public String editLang(@RequestBody language l) {
		
		return langDAO.editLang(l)+" Language edited successfully";
		
	
	}
}

