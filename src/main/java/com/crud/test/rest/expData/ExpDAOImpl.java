package com.crud.test.rest.expData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class ExpDAOImpl implements ExpDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
	public List<Exp> findAll() {
		return jdbcTemplate.query("SELECT * FROM industry", new BeanPropertyRowMapper<Exp>(Exp.class));
	}

	@Override
	public List<Exp> findExpData(Exp xp) {
				System.out.println(xp.getSeller_id());
		return jdbcTemplate.query("SELECT experience.*, industry.industry_type FROM experience LEFT JOIN industry ON experience.industry_id = industry.industry_id where seller_id = ?;", new BeanPropertyRowMapper<Exp>(Exp.class),xp.getSeller_id());
	}

	@Override
	public Exp ExpIndustryID(Exp xp) {
		System.out.println(xp.getIndustry_type());
		
		return jdbcTemplate.queryForObject("SELECT industry_id FROM industry WHERE industry_type=?", new BeanPropertyRowMapper<Exp>(Exp.class),xp.getIndustry_type());
	}

    @Override
	public int saveExp(Exp xp) {
		
		return jdbcTemplate.update("INSERT INTO experience (job,joined_start,joined_end,description,company_name,seller_id,industry_id) VALUES (?, ?, ?,?, ?, ?,?)", new Object[] {xp.getJob(),xp.getJoined_start(),xp.getJoined_end(),xp.getDescription(),xp.getCompany_name(),xp.getSeller_id(),xp.getIndustry_id()});

	}

	@Override
	public int deleteExperience(Exp xp) {
		
		return jdbcTemplate.update("DELETE from experience where experience_id = ?", xp.getExperience_id());

	}


	@Override
	public int editExperience(Exp xp) {

		return jdbcTemplate.update("UPDATE experience SET job = ? ,joined_start = ? , joined_end = ? ,description = ? ,company_name = ?, industry_id = ? WHERE experience_id = ?", xp.getJob(),xp.getJoined_start(),xp.getJoined_end(),xp.getDescription(),xp.getCompany_name(),xp.getIndustry_id(),xp.getExperience_id());

	}
}
