package com.crud.test.rest.sellerData;

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
	public List<Seller> findAll2() {
		return jdbcTemplate.query("SELECT seller_table.*, state.state_name FROM seller_table LEFT JOIN state ON seller_table.state_id = state.state_id ORDER BY seller_name ASC;;", new BeanPropertyRowMapper<Seller>(Seller.class));
	}

	@Override
	public Seller findSellerData(Seller s) {
		
		return jdbcTemplate.queryForObject("SELECT seller_table.*, state.state_name FROM seller_table LEFT JOIN state ON seller_table.state_id = state.state_id WHERE seller_table.seller_id = ?;", new BeanPropertyRowMapper<Seller>(Seller.class),s.getSeller_id());
	}

	@Override
	public int validateData(Seller s){
		var validate = jdbcTemplate.queryForMap("SELECT COUNT(user_id) FROM seller_table WHERE user_id=?", s.getUser_id());
		System.out.println(validate.get("count"));
		long i = (Long) validate.get("count");
		if(i >= 1){
			System.out.println("ALREADY INSERT INFO");
			throw new DataAlreadyExistsException("ALREADY INSERT INFO");
		}return 0;
	}

	@Override
	public Seller StateID(Seller s) {
		System.out.println(s.getState_name());
		
		return jdbcTemplate.queryForObject("SELECT state_id FROM state WHERE state_name=?", new BeanPropertyRowMapper<Seller>(Seller.class),s.getState_name());
	}

	@Override
	public int saveData(Seller s) {
		
		System.out.println("User ID: " + s.getUser_id());
System.out.println("Seller Name: " + s.getSeller_name());
System.out.println("Date of Birth: " + s.getDof());
System.out.println("Telephone Number: " + s.getTel_no());
System.out.println("Address: " + s.getAddress());
System.out.println("State ID: " + s.getState_name());
System.out.println("Occupation: " + s.getOccupation());
System.out.println("Expected Salary: " + s.getEx_salary());
System.out.println("Years of Work Experience: " + s.getWork_expyr());

		return jdbcTemplate.update("INSERT INTO seller_table (user_id,  seller_name, dof, tel_no, address, state_id, occupation, ex_salary, work_expyr) VALUES (?, ?, ?, ?, ?, ?, ?, CAST(? as MONEY), ?)", new Object[] {s.getUser_id(), s.getSeller_name(),s.getDof(),s.getTel_no(),s.getAddress(),s.getState_id(),s.getOccupation(),s.getEx_salary(),s.getWork_expyr()});

	}

	@Override
	public Seller SellerID(Seller s) {
		System.out.println(s.getUser_id());
		
		return jdbcTemplate.queryForObject("SELECT seller_id FROM seller_table WHERE user_id=?", new BeanPropertyRowMapper<Seller>(Seller.class),s.getUser_id());
	}

	
}
