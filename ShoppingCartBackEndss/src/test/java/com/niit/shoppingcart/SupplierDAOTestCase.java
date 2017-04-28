package com.niit.shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;

public class SupplierDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static SupplierDAO  supplierDAO;
	
	@Autowired  static Supplier supplier;
	
	
	//The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case
	 * and will execute only once
	 */
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		supplierDAO =  (SupplierDAO) context.getBean("supplierDAO");
		
		//get the user from context
		
		supplier= (Supplier)context.getBean("supplier");
	}
	@Test
	public void createSupplierTestCase()
	{
		supplier.setId("1234"
				);
		supplier.setName("rahul");

		boolean flag =  supplierDAO.save(supplier);
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createSupplierTestCase  qweerr",false,flag);
		
	}
}

