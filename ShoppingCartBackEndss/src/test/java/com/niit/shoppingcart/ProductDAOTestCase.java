package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;

public class ProductDAOTestCase {
	
	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired  static ProductDAO  productDAO;
	
	@Autowired  static Product product;
	
	
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
		productDAO =  (ProductDAO) context.getBean("productDAO");
		
		//get the user from context
		
		product = (Product)context.getBean("product");
		
}
	@Test
	public void createUserTestCase()
	{
		product.setId(""
				+ "");
		product.setName("rahul");
		product.setCategoryID("000");
		product.setPrice("19999");
		product.setProductID("8778787979");
		boolean flag =  productDAO.save(product);
	

}

@Test
public void  getAllProductTestCase()
{
	int actualSize=productDAO.list().size();
	assertEquals(12,actualSize);
}
}
