package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {

	
	
	// create/register  - save
	
	public  boolean save(Supplier supplier);
	
	// update the user details  - update
	public boolean update(Supplier supplier);
	
	// validate the credentials  -  validate
	//WE are going to use spring security in future.
	//we can delete this method. after using spring security.
	public boolean delete(String id);
	
	// get all users   - list
	
	public List<Supplier>     list();
	
	
	//get user details based on userID
	
	public Supplier getSupplierByID(String id);
	public Supplier getSupplierByName(String name);
	
	
	
	
	
	
}
