package com.Tshirts.ekart.dao;

import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository("categdao")
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	SessionFactory sf;

	public boolean addCreate(Category cat) {
		try {
		sf.getCurrentSession().save(cat);
		return true;
	}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	
	}

	public Category getCid(int cid) {
		try {
			return sf.getCurrentSession().get(Category.class, cid);
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public List<Category> retrieveAllUsers() {
		try {
			return sf.getCurrentSession().createQuery("from Category",Category.class).getResultList();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public boolean update(Category cat) {
		try {
			sf.getCurrentSession().update(cat);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public boolean delete(Category cat) {

		try {
			sf.getCurrentSession().remove(cat);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		
		
		return false;
	}

	public Category getCategory(int cid) {
		try {
			return sf.getCurrentSession().get(Category.class, cid);
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

}
