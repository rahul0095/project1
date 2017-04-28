package com.niit.shoppingcart;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.domain.Category;

public class categoryDAO {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		context.getBean("category");
		System.out.println("the user instance is created successfully");



}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return null;
	}}
