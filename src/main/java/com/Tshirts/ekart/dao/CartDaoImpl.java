package com.Tshirts.ekart.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tshirts.ekart.model.Cart;
@Transactional
@Repository("cartdao")
public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sf;

	public boolean add(Cart cart) {
		try {
			sf.getCurrentSession().save(cart);
			return true;
		}
			catch(Exception e)
			{
				System.out.println(e);
				return false;
		
	}
	}

	public boolean update(Cart cart) {
		try {
			sf.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public boolean delete(Cart cart) {
		 try {
			   sf.getCurrentSession().remove(cart);
			   return true;
			  } catch (Exception e) {
			   return false;
			  }
	}

	public Cart get(int cid) {
		 try {
			   return sf.getCurrentSession().get(Cart.class, cid);
			  } catch (Exception e) {
			   System.out.println(e);
			   return null;
			  }
	}
	

}
