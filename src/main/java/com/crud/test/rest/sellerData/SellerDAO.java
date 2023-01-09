package com.crud.test.rest.sellerData;

import java.util.List;


public interface SellerDAO {

	public List<Seller> findAll();
	public int saveData(Seller s);
	public int validateData(Seller s);
	public Seller StateID(Seller s);
	public Seller SellerID(Seller s);
}