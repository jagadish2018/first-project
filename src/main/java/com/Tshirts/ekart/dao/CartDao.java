package com.Tshirts.ekart.dao;

import org.springframework.stereotype.Component;

import com.Tshirts.ekart.model.Cart;

@Component
public interface CartDao {
	public boolean add(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(Cart cart);
	 public Cart get(int cid);

}
