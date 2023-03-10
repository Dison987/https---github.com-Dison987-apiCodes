package com.crud.test.rest.profileData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SkillDAOImpl implements SkillDAO {
    @Autowired
	JdbcTemplate jdbcTemplate;
	
    @Override
	public List<Skill> findAll() {
		return jdbcTemplate.query("SELECT * FROM skill_proficient", new BeanPropertyRowMapper<Skill>(Skill.class));
	}
	@Override
	public Skill SkillProfID(Skill sk) {
		System.out.println(sk.getSkill_proficient_type());
		
		return jdbcTemplate.queryForObject("SELECT skill_proficient_id FROM skill_proficient WHERE skill_proficient_type=?", new BeanPropertyRowMapper<Skill>(Skill.class),sk.getSkill_proficient_type());
	}

    @Override
	public int saveSkill(Skill sk) {
		
		return jdbcTemplate.update("INSERT INTO skill (seller_id,skill_name,skill_proficient_id) VALUES (?, ?, ?)", new Object[] {sk.getSeller_id(),sk.getSkill_name(),sk.getSkill_proficient_id()});

	}

	@Override
	public List<Skill> findSkills(Skill sk) {
		System.out.println(sk.getSeller_id());
		
		return jdbcTemplate.query("SELECT skill.*, skill_proficient.skill_proficient_type  FROM skill JOIN skill_proficient ON skill.skill_proficient_id = skill_proficient.skill_proficient_id WHERE skill.seller_id = ?;", new BeanPropertyRowMapper<Skill>(Skill.class),sk.getSeller_id());
	}

	@Override
	public int deleteSkill(Skill sk) {
		System.out.println(sk.getSkill_id());
		return jdbcTemplate.update("DELETE from skill where skill_id = ?", sk.getSkill_id());

	}


	@Override
	public int editSkill(Skill sk) {

		return jdbcTemplate.update("UPDATE skill SET skill_name = ? ,skill_proficient_id = ? WHERE skill_id = ?", sk.getSkill_name(),sk.getSkill_proficient_id(),sk.getSkill_id());

	}
}
