package com.niit.shoppingcart.daoimpl;


	import java.util.List;



	import javax.transaction.Transactional;

	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import com.niit.shoppingcart.dao.ProductDAO;
	import com.niit.shoppingcart.domain.Product;


	@Repository("ProductDAO")
	@Transactional
	public class ProductDAOImpl implements ProductDAO {

		@Autowired
		private SessionFactory sessionFactory;
public void ProductImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
private Session getCurrentSession()
{
	return sessionFactory.getCurrentSession();
}
		public boolean save(Product product) {
			try {
				Session session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				

				session.save(product);// this will save the user inside H2 db
				tx.commit();
				session.flush();
				session.close();
			}

			catch (Exception e) {
				// if any excpetion comes during execute of try block, catch will
				// excute
				e.printStackTrace();
				return false;
			}
			return true;
		}


		

		public List<Product> list() {

			return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}

		public Product get(String name) {

			// get method get the date from user table based on primary key i.e., id
			// and set it to User class
			// like select * from user where id = ?
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createQuery("from User where name=?");
			query.setString(0, name);
			Product product = (Product) query.uniqueResult();

			tx.commit();
			session.flush();
			session.close();
			return product;
			
		}

	}


