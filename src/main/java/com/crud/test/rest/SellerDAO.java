package com.crud.test.rest;

import java.util.List;


public interface SellerDAO {

	public List<Seller> findAll();
	public int saveData(Seller s);


}