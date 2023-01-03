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

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;



    @RestController

public class ApiController {
	
	@Autowired 
	private UserDAO eDAO;
	
    //GetMapping
    @RequestMapping({"/Users","testing"})
	public List<User> findAll() {
		return eDAO.findAll();
	}
	// @GetMapping("/Users")
	// public List<User> findAll() {
	// 	return eDAO.findAll();
	// }
	

	@GetMapping("/Users/{id}")
	public User findById(@PathVariable int id) {
		return eDAO.findById(id);
	}

	// @GetMapping("/Users")
	// public User findUsersId(@RequestBody Map<String, String> params) {
	// 	int id = Integer.parseInt(params.get("id"));
	// 	return eDAO.findById(id);
	// }
	
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

    @PostMapping("/login")
	public User login(@RequestBody User e) {
	    try {

			return eDAO.login(e);
		} catch (EmptyResultDataAccessException ex) {
			throw new ResponseStatusException(
			  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		}
		// return eDAO.login(e);

		
    
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

	@PostMapping("/test2")
	public String test2(@RequestHeader String auth) {
		System.out.println("printing the auth "+auth);
		return "Success";
	    // try {
		// 	return eDAO.UserId(auth);
		// } catch (EmptyResultDataAccessException ex) {
		// 	throw new ResponseStatusException(
		// 	  HttpStatus.UNAUTHORIZED, "Incorrect Email or Password", ex);
		// }
	}


    
	@GetMapping("/test3")
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
}

