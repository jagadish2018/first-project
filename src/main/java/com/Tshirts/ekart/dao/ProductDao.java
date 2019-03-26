package com.Tshirts.ekart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;

@Component
public interface ProductDao {
	public boolean addCreate(Product product);
	public Product getPid(int pid);
	public boolean update(Product product);
	public List<Product> retrieveAllProducts();
	public Product getProduct(int pid);
	public boolean delete(Product product);


	

}
