package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;

import com.niit.shoppingcart.domain.Category;

public interface CategoryDAO {
	// get all the category
	public List<Category> list();
	public boolean save (Category category);
	public boolean update (Category category);
	public boolean delete(Category category);
	public Category getCategoryByID(String id);
	public Category getCategoryByNmae(String name);
	
	
}
	
	
	
	
	
	
	
	
	


