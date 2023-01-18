package com.crud.test.rest.profileData;

import java.util.List;


public interface SkillDAO {

	public List<Skill> findAll();

	public int saveSkill(Skill sk);
	public Skill SkillProfID(Skill sk);
  
	public List<Skill> findSkills(Skill s);
	public int editSkill(Skill sk);
	public int deleteSkill(Skill sk);
}

