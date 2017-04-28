package com.niit.shoppingcart;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

public class CategoryDAOTestCase{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static categoryDAO categoryDAO;
	@Autowired static Category category;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		categoryDAO =  (categoryDAO) context.getBean("categoryDAO");
		
		//get the user from context
		
		category = (Category)context.getBean("category");
	}
	@Test
	public void getAllcategoriesTestCase()
	{
		List<Category> categories=categoryDAO.list();
		assertEquals(0,categories.size());
	
	}

}
