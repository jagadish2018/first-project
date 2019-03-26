package com.Tshirts.ekart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.Tshirts.ekart.model.Category;

@Component
public interface CategoryDao {
	public boolean addCreate(Category cat);
	public Category getCid(int cid);
	public List<Category> retrieveAllUsers();
	public boolean update(Category cat);
	public boolean delete(Category cat);
	public Category getCategory(int cid);

}
