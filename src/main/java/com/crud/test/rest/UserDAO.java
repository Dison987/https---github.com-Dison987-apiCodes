package com.crud.test.rest;

import java.util.List;


public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public int deleteById(int id);
	
	public int save(User e);
	
	public int updateRole(User e);

	public User login(User e);

	public User loginId(User e);

	public User UserId(User e);

	public User UserIdAdmin(User e);
}