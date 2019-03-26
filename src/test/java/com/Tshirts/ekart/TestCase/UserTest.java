package com.Tshirts.ekart.TestCase;



import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.db_configuration.Mainfile;
import com.Tshirts.ekart.model.User;
public class UserTest {
	AnnotationConfigApplicationContext context;
	User us;
	UserDao ud;
	
	

	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext(Mainfile.class);
	ud=(UserDao)context.getBean("cuserdao");
	us=new User();
	}


	/*@Test
	public void test() {
		us.setAddress("basheerbagh");
		us.setName("jagadish");
		us.setMobileno("9491266704");
		us.setEmailid("jvj@yahoo.com");
		us.setPassword("kumar");
		us.setConfirmPassword("kumar");
		ud.addCreate(us);
	}*/
	//this testcase is to retrieve specific records
	/*@Test
	public void test()
	{
		us=ud.getId(1);
		System.out.println("c name="+us.getName());
	}*/
	//retrieve all the records
	@Test
	public void test()
	{
		List<User> ul=ud.retrieveAllUsers();
		for(int i=0;i<ul.size();i++)
		{
			User us=(User)ul.get(i);
			System.out.println(us.getAddress()+"\t"+us.getMobileno());

		}
		}
//updating specific record
	/*@Test
	public void test()
	{
		us=ud.getId(1);
		us.setName("nagendra");
		us.setAddress("beeramguda");
		assertEquals("updated",true,ud.update(us));
	}*/
	//deleting record
	/*@Test
	public void test()
	{
		us.setId(2);
		assertEquals("deleted",true,ud.delete(us));
		
	}*/

}
