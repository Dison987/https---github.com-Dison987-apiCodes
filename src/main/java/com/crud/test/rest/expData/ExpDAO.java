package com.crud.test.rest.expData;

import java.util.List;


public interface ExpDAO {

	public List<Exp> findAll();
	public List<Exp> findExpData(Exp xp);
	public int saveExp(Exp xp);
	public Exp ExpIndustryID(Exp xp);
	public int deleteExperience(Exp xp);
	public int editExperience(Exp xp);
}