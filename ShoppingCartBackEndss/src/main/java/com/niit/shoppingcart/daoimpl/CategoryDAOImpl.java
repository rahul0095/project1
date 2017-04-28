package com.niit.shoppingcart.daoimpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.domain.Category;



@Repository("CategoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	

	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;   
   }
	public List<Category> list() {

		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean save(Category category) {
		try
		{
			getCurrentSession().save(category);
		}
		catch(Exception e){
			
		}
		return true;
	}

	


	private CategoryDAO getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}
	public Category getCategoryByID(String id) {
		
		return (Category) getCurrentSession().get(Category.class,id);
	}

	public Category getCategoryByName(String name) {
		
		 Query query = getCurrentSession().createQuery("from category where name=?");
		query.setString(0,name);
		return(Category) query.uniqueResult();
	}

	public boolean delete(Category category) {
		try
		{
			getCurrentSession().delete(getCategoryByID(id));
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		}
		return false;
	


	}
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		return false;
	
	}
	public Category getCategoryByNmae(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
	


