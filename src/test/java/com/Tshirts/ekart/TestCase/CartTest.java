package com.Tshirts.ekart.TestCase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Tshirts.ekart.dao.CartDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.db_configuration.Mainfile;
import com.Tshirts.ekart.model.Cart;
import com.Tshirts.ekart.model.CartItems;
import com.Tshirts.ekart.model.Product;

public class CartTest {
	UserDao ud;
	ProductDao pd;
	CartDao cd;
	Cart ca;
	Product pr;
	CartItems ci;
	
	AnnotationConfigApplicationContext context;
	List<CartItems> csi;
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext(Mainfile.class);
		pd=(ProductDao)context.getBean("proddao");
		ud=(UserDao)context.getBean("cuserdao");
		cd=(CartDao)context.getBean("cartdao");
		ca=new Cart();
		ci=new CartItems();
		pr=pd.getPid(1);
		ci.setProd(pr);
		ca.setUser(ud.getId(1));
		ci.setCart(ca);
		ci.setProd(pr);
		ci.setCiprice(pr.getPrice());
		ci.setCiquantity(1);
		csi=new ArrayList<CartItems>();
		csi.add(ci);
		ca.setCquantity(ci.getCiquantity());
		ca.setCprice(ci.getCiprice());
		ca.setCsi(csi);
		
	}

	@Test
	public void test() {
		assertEquals(true,cd.add(ca));
		
	}

}
