package com.crud.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("SELECT * FROM user_table", new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM user_table WHERE user_id=?", new BeanPropertyRowMapper<User>(User.class), id);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM user_table WHERE user_id=?", id);
	}

	// @Override
	// public int save(User e) {
	// 	return jdbcTemplate.update("INSERT INTO user_table (username, email,phoneNo, password) VALUES (?, ?,?, ?)", new Object[] {e.getUsername(), e.getEmail(),e.getPhoneNo(), e.getPassword()});
	// }

	@Override
	public int save(User e) {
		var validate = jdbcTemplate.queryForMap("SELECT COUNT(email) FROM user_table WHERE email=?", e.getEmail());
		System.out.println(validate.get("count"));
		long i = (Long) validate.get("count");
		if(i >= 1){
			System.out.println("EMAIL ALR EXISTED");
			throw new UserAlreadyExistsException("Email Already Existed");
		}

		return jdbcTemplate.update("INSERT INTO user_table (username, email,phoneNo, password) VALUES (?, ?,?, ?)", new Object[] {e.getUsername(), e.getEmail(),e.getPhoneNo(), e.getPassword()});
	}

	@Override
	public int updateRole(User e) {
		System.out.println(e.getUser_id());
		return jdbcTemplate.update("UPDATE user_table SET role = 'Admin' WHERE user_id = ?", new Object[] {e.getUser_id()});

	}

	// @Override
	// public User login() {
		
	
	// 	return  jdbcTemplate.queryForObject("SELECT user_id FROM user_table WHERE email='johndoetest@gmail.com'", new BeanPropertyRowMapper<User>(User.class));
	// }
	@Override
	public User login(User e) {
		System.out.println(e.getEmail());
		System.out.println(e.getPassword());
		var email = e.getEmail();
		var pw = e.getPassword();
		System.out.println(JWTGenerateValidateHMAC.createJwtSignedHMAC(e.getEmail()));
		 e.setToken(JWTGenerateValidateHMAC.createJwtSignedHMAC(e.getEmail()));
		 var token = e.getToken();
		 System.out.println(token);
		
		var response = jdbcTemplate.queryForObject("SELECT * FROM user_table WHERE email=? AND password=?", new BeanPropertyRowMapper<User>(User.class),email,pw);
		System.out.println(response);
		response.setToken(token);
		return response;
	}
	
	@Override
	public User loginId(User e) {
		System.out.println(e.getEmail());
		var email = e.getEmail();
		
		// return jdbcTemplate.queryForObject("SELECT user_id FROM user_table WHERE email=?", new BeanPropertyRowMapper<User>(User.class),email);
		return jdbcTemplate.queryForObject("SELECT * FROM user_table WHERE email=?", new BeanPropertyRowMapper<User>(User.class),email);
	}

	@Override
	public User UserId(User e) {
		System.out.println(e.getUser_id());
		
		return jdbcTemplate.queryForObject("SELECT user_id,username, email,phoneNo FROM user_table WHERE user_id=?", new BeanPropertyRowMapper<User>(User.class),e.getUser_id());
	}

	@Override
	public User UserIdAdmin(User e) {
		System.out.println(e.getUser_id());
		
		return jdbcTemplate.queryForObject("SELECT * FROM user_table WHERE user_id=?", new BeanPropertyRowMapper<User>(User.class),e.getUser_id());
	}
}
