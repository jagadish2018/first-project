package com.Tshirts.ekart.dao;
import java.util.List;


import org.springframework.stereotype.Component;
import com.Tshirts.ekart.model.User;

@Component
public interface UserDao {
	public boolean addCreate(User  user);
	public User getId(int id);
	public List<User> retrieveAllUsers();
	public User getUserDetails(String emailid);
	public boolean update(User user);
	public boolean delete(User user);

}
