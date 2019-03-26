package com.Tshirts.ekart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;
@Transactional
@Repository("proddao")
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sf;

	public boolean addCreate(Product product) {
		try {
			sf.getCurrentSession().save(product);
			return true;
		}
			catch(Exception e)
			{
				System.out.println(e);
				return false;
		
	}
	

}

	public Product getPid(int pid) {
		try {
			return sf.getCurrentSession().get(Product.class, pid);
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public boolean update(Product product) {
		try {
			sf.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public List<Product> retrieveAllProducts() {
		try {
			return sf.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public Product getProduct(int pid) {
		try {
			return sf.getCurrentSession().get(Product.class, pid);
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public boolean delete(Product product) {
		try {
			sf.getCurrentSession().remove(product);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
		
		return false;
	}
	
}
