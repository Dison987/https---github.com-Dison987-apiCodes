package com.crud.test.rest.educationData;

import java.util.List;


public interface EduDAO {

	public List<Edu> findAll();

	public int saveEdu(Edu ed);
	public Edu EduQualiID(Edu ed);


}