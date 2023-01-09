package com.crud.test.rest.educationData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EduDAOImpl implements EduDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
	public List<Edu> findAll() {
		return jdbcTemplate.query("SELECT * FROM skill_proficient", new BeanPropertyRowMapper<Edu>(Edu.class));
	}
	@Override
	public Edu EduQualiID(Edu ed) {
		System.out.println(ed.getQualification_type());
		
		return jdbcTemplate.queryForObject("SELECT qualification_id FROM qualification WHERE qualification_type=?", new BeanPropertyRowMapper<Edu>(Edu.class),ed.getQualification_type());
	}

    @Override
	public int saveEdu(Edu ed) {
		
		return jdbcTemplate.update("INSERT INTO education (university,graduation_date,field_of_study,cgpa,seller_id,qualification_id) VALUES (?, ?, ?,?, ?, ?)", new Object[] {ed.getUniversity(),ed.getGraduation_date(),ed.getField_of_study(),ed.getCgpa(),ed.getSeller_id(),ed.getQualification_id()});

	}
}
