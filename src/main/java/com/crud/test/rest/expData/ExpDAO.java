package com.crud.test.rest.expData;

import java.util.List;


public interface ExpDAO {

	public List<Exp> findAll();

	public int saveExp(Exp xp);
	public Exp ExpIndustryID(Exp xp);


}