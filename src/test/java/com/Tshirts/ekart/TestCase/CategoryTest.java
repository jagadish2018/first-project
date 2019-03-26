package com.Tshirts.ekart.TestCase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Tshirts.ekart.dao.CategoryDao;

import com.Tshirts.ekart.db_configuration.Mainfile;
import com.Tshirts.ekart.model.Category;

import junit.framework.Assert;


public class CategoryTest {
	AnnotationConfigApplicationContext context;
	Category ca;
	CategoryDao cd;

	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext(Mainfile.class);
	cd=(CategoryDao)context.getBean("categdao");
	ca=new Category();
	}
	/*@Test
	public void test() {
		ca.setCname("jagadish");
		ca.setCdescription("working");
		Assert.assertEquals("record success", true,cd.addCreate(ca));
		
	}*/
	/*@Test
	public void test()
	{
		ca=cd.getCid(1);
		System.out.println("c name="+ca.getCname());
	}*/
	/*@Test
	public void test()
	{
		List<Category> cl=cd.retrieveAllUsers();
		for(int i=0;i<cl.size();i++)
		{
			Category ca=(Category)cl.get(i);
			System.out.println(ca.getCname()+"\t"+ca.getCdescription());

		}
	}*/
	
	
	@Test
	public void test()
	{
		ca.setCid(2);
		assertEquals("deleted",true,cd.delete(ca));
		
	}
	
	
	
	
	
}
