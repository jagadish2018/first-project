package com.Tshirts.ekart.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tshirts.ekart.model.Cart;
import com.Tshirts.ekart.model.CartItems;
import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;

@Transactional
@Repository("cartidao")
public class CartItemsDaoImpl implements CartItemsDao{
	@Autowired
	SessionFactory sf;
	
	public boolean add(CartItems carti) {
		try {
			sf.getCurrentSession().save(carti);
			return true;
		}
			catch(Exception e)
			{
				System.out.println(e);
				return false;
		
	}
	}

	public boolean update(CartItems carti) {
		try {
			sf.getCurrentSession().update(carti);
			return true;
		}
		catch(Exception ae)
		{
			System.out.println(ae);
		}
		return false;
	}

	public CartItems getProduct(int pid, int cid) {
		try {
			return sf.getCurrentSession().createQuery("from CartItems where cart_cartId = :cid and product_productId= :pid",CartItems.class).setParameter("cartId", cid).setParameter("productId", pid).getSingleResult();
		}
		catch(Exception ae)
		{
			System.out.println(ae);
			return null;
		}
		
	}

	public CartItems get(int ciid) {
		try {
			   return sf.getCurrentSession().get(CartItems.class, ciid);
			  } catch (Exception e) {
			   System.out.println(e);
			   return null;
			  }
	}

	public ArrayList<CartItems> retreiveAllCartItems() {
		try {
			   return (ArrayList<CartItems>) sf.getCurrentSession().createQuery("from CartItems", CartItems.class).getResultList();
			  } catch (HibernateException e) {
			   e.printStackTrace();
			   return null;
			  }
	}

	public boolean delete(CartItems carti) {
		try {
			   sf.getCurrentSession().remove(carti);
			   return true;
			  } catch (Exception e) {
			   return false;
			  }
	}

}
