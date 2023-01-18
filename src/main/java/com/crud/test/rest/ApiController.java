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
	
	@PostMapping("/SignUp")
	public String save(@RequestBody User e) {
		try{
		return eDAO.save(e)+" User(s) saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

	@PostMapping("/changeAdmin")
	public String updateRole(@RequestBody User e) {
		
		return eDAO.updateRole(e)+" User(s) Updated successfully";
	
	
	}

	@PostMapping("/changeUser")
	public String updateRoleUser(@RequestBody User e) {
		
		return eDAO.updateRoleUser(e)+" User(s) Updated successfully";
	
	
	}



    @PostMapping("/login")
	public User login(@RequestBody User e) {
	    try {

			return eDAO.login(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}

		
    
	}


	@PostMapping("/loginId")
	public User loginIdUser(@RequestBody User e) {
	    try {
			return eDAO.loginId(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}
	}

	@PostMapping("/UserId")
	public User UserId(@RequestBody User e) {
	    try {
			return eDAO.UserId(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}
	}

	@PostMapping("/UserIdAdmin")
	public User UserIdAdmin(@RequestBody User e) {
	    
			return eDAO.UserIdAdmin(e);
		
	}

	@PostMapping("/test2")
	public String test2(@RequestHeader String auth) {
		System.out.println("printing the auth "+auth);
		return "Success";

	}


    
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

@RequestMapping({"/sellerList"})
public List<Seller> findAll2() {
	return sDAO.findAll2();
}

@PostMapping("/seller")
	public String saveData(@RequestBody Seller s) {
		try{
		return sDAO.saveData(s)+" User(s) saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}
	
	@PostMapping("/findSellerData")
	public Seller findSellerData(@RequestBody Seller s) {
	   
			return sDAO.findSellerData(s);
		
	}

	@PostMapping("/StateID")
	public Seller StateId(@RequestBody Seller s) {
	   
			return sDAO.StateID(s);
		
	}

	@PostMapping("/check")
	public String validateData(@RequestBody Seller s) {
		
		return sDAO.validateData(s)+"ALREADY INSERTED";
	}

	@RequestMapping({"/Sellers"})
	public List<Seller> findAlls() {
		return sDAO.findAll();
	}

	@PostMapping("/SellerID")
	public Seller SellerId(@RequestBody Seller s) {
	   
			return sDAO.SellerID(s);
		
	}


	//Skill 
	@PostMapping("/SkillProfID")
	public Skill SkillProfId(@RequestBody Skill sk) {
			return skillDAO.SkillProfID(sk);
	}

	@RequestMapping({"/Skills"})
	public List<Skill> findAllskill() {
		return skillDAO.findAll();
	}

	@PostMapping("/createSkill")
	public String saveSkill(@RequestBody Skill sk) {
		try{
		return skillDAO.saveSkill(sk)+" Skill saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

	@PostMapping("/findSkills")
	public List<Skill> findSkills(@RequestBody Skill sk) {
	   
			return skillDAO.findSkills(sk);
		
	}

	@PostMapping("/deleteSkill")
	public String deleteSkill(@RequestBody Skill sk) {
		
		return skillDAO.deleteSkill(sk)+" Skill deleted successfully";
		
	}

	@PostMapping("/editSkill")
	public String editSkill(@RequestBody Skill sk) {
		
		return skillDAO.editSkill(sk)+" Skill edited successfully";
		
	
	}
	

	//Education

	@PostMapping("/findEduData")
	public List<Edu> findEduData(@RequestBody Edu ed) {
	   
			return eduDAO.findEduData(ed);
		
	}

	@RequestMapping({"/Qualifications"})
			public List<Edu> findAllEdu() {
				return eduDAO.findAll();
			}

	@PostMapping("/EduQualiID")
	public Edu EduQualiID(@RequestBody Edu ed) {
			return eduDAO.EduQualiID(ed);
	}



	@PostMapping("/createEdu")
	public String saveEdu(@RequestBody Edu ed) {
		try{
		return eduDAO.saveEdu(ed)+" Education saved successfully";
		}catch(UserAlreadyExistsException ex){
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
		}
	
	}

	@PostMapping("/deleteEducation")
	public String deleteEducation(@RequestBody Edu ed) {
		
		return eduDAO.deleteEducation(ed)+" Edu deleted successfully";
		
	}

	@PostMapping("/editEducation")
	public String editEducaiton(@RequestBody Edu ed) {
		
		return eduDAO.editEducation(ed)+" Edu edited successfully";
		
	
	}

		//Experience

		@PostMapping("/findExpData")
		public List<Exp> findExpData(@RequestBody Exp xp) {
		   
				return expDAO.findExpData(xp);
			
		}

		@RequestMapping({"/Industry"})
		public List<Exp> findAllExp() {
			return expDAO.findAll();
		}

		@PostMapping("/ExpIndustryID")
		public Exp EduQualiID(@RequestBody Exp xp) {
				return expDAO.ExpIndustryID(xp);
		}

		
	
	
	
		@PostMapping("/createExp")
		public String saveExp(@RequestBody Exp xp) {
			try{
			return expDAO.saveExp(xp)+" Experience saved successfully";
			}catch(UserAlreadyExistsException ex){
				throw new ResponseStatusException(
				  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
			}
		
		}

		@PostMapping("/deleteExperience")
		public String deleteExperience(@RequestBody Exp xp) {
			
			return expDAO.deleteExperience(xp)+" Exp deleted successfully";
			
		}
	
		@PostMapping("/editExperience")
		public String editExperience(@RequestBody Exp xp) {
			
			return expDAO.editExperience(xp)+" Exp edited successfully";
			
		
		}


			//Language
			@PostMapping("/findLanguages")
			public List<language> findLanguage(@RequestBody language l) {
			   
					return langDAO.findLanguage(l);
				
			}

			@RequestMapping({"/Languages"})
			public List<language> findAlllanguage() {
				return langDAO.findAll();
			}
		

			@PostMapping("/langTypeID")
			public language langTypeID(@RequestBody language l) {
					return langDAO.langTypeID(l);
			}
		
		
			@PostMapping("/langProfID")
			public language langProfID(@RequestBody language l) {
					return langDAO.langProfID(l);
			}
		
			@PostMapping("/createLang")
			public String saveLang(@RequestBody language l) {
				try{
				return langDAO.saveLang(l)+" Language saved successfully";
				}catch(UserAlreadyExistsException ex){
					throw new ResponseStatusException(
					  HttpStatus.UNAUTHORIZED, "Email Already Existed", ex);
				}
			
			}

			@PostMapping("/deleteLang")
			public String deleteLang(@RequestBody language l) {
				
				return langDAO.deleteLang(l)+" Language deleted successfully";
				
			}

			@PostMapping("/editLang")
			public String editLang(@RequestBody language l) {
				
				return langDAO.editLang(l)+" Language edited successfully";
				
			
			}
}

