package com.crud.test.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SellerDAOImpl implements SellerDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Seller> findAll() {
		return jdbcTemplate.query("SELECT * FROM seller_table", new BeanPropertyRowMapper<Seller>(Seller.class));
	}

	@Override
	public int saveData(Seller s) {
		var validate = jdbcTemplate.queryForMap("SELECT COUNT(user_id) FROM seller_table WHERE user_id=?", s.getUser_id());
		System.out.println(validate.get("count"));
		long i = (Long) validate.get("count");
		if(i >= 1){
			System.out.println("EMAIL ALR EXISTED");
			throw new UserAlreadyExistsException("Email Already Existed");
		}

		return jdbcTemplate.update("INSERT INTO seller_table (user_id,seller_name, dof,telno, address,state_id,occupation,ex_salary,work_expyr) VALUES (?,?, ?,?, ?,?,?,?,?)", new Object[] {s.getUser_id(),s.getSellerName(),s.getDof(),s.getTelNo(),s.getAddress(),s.getStateID(),s.getOccupation(),s.getExpectedSalary(),s.getWorkExp()});
		

		
	}

	
}
