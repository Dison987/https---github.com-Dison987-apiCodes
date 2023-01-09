package com.crud.test.rest.profileData;

import java.util.List;


public interface SkillDAO {

	public List<Skill> findAll();

	public int saveSkill(Skill sk);
	public Skill SkillProfID(Skill sk);


}

