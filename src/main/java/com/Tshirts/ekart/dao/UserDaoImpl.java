package com.Tshirts.ekart.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tshirts.ekart.model.User;
@Transactional
@Repository("cuserdao")
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sf;

	public boolean addCreate(User user) {
		sf.getCurrentSession().persist(user);
		return true;
	}

	public User getId(int id) {
		try {
			return sf.getCurrentSession().get(User.class, id);
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public List<User> retrieveAllUsers() {
		try {
			return sf.getCurrentSession().createQuery("from User",User.class).getResultList();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return null;
	}

	public boolean update(User user) {
		try {
			sf.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public boolean delete(User user) {
		try {
			sf.getCurrentSession().remove(user);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public User getUserDetails(String emailid) {
		try {
			return sf.getCurrentSession().createQuery("from User where emailid=:emailid",User.class).setParameter("emailid", emailid).getSingleResult();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
			return null;
		}
	}

	}
	

