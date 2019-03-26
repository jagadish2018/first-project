package com.Tshirts.ekart.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.Tshirts.ekart.model.CartItems;


@Component
public interface CartItemsDao {
	public boolean add(CartItems carti);
	public boolean update(CartItems carti);
	public CartItems getProduct(int pid, int cid);
	public CartItems get(int ciid);
	public ArrayList<CartItems> retreiveAllCartItems();
	public boolean delete(CartItems carti);
}
