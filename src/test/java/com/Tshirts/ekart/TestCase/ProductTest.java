package com.Tshirts.ekart.TestCase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Tshirts.ekart.dao.CategoryDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.db_configuration.Mainfile;
import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;
import com.Tshirts.ekart.model.User;

import junit.framework.Assert;

public class ProductTest {
	AnnotationConfigApplicationContext context;
	Product pr;
	ProductDao pd;
	Category ca;
	CategoryDao cd;
	@Before
	public void init()
	{
	context = new AnnotationConfigApplicationContext(Mainfile.class);
	pd=(ProductDao)context.getBean("proddao");
	pr=new Product();
	cd=(CategoryDao)context.getBean("categdao");
	ca=new Category();
	
	}
	/*@Test
	public void test() {
		
		ca.setCname("jagadish");
		ca.setCdescription("working");
		pr.setPname("chocolate");
		pr.setPdescription("asha chocolate");
		pr.setPrice(2);
		pr.setCategory(ca);
		Assert.assertEquals("success",true,cd.addCreate(ca));
		Assert.assertEquals("success", true,pd.addCreate(pr));

		
		
	}*/
	/*@Test
	public void test()
	{
		pr=pd.getPid(1);
		System.out.println("p name and description="+pr.getPname());
		
	}*/
	@Test
	public void test()
	{
		pr=pd.getPid(1);
		pr.setPname("Television");
		pr.setPdescription("led tv");
		assertEquals("updated",true,pd.update(pr));
	}

}
