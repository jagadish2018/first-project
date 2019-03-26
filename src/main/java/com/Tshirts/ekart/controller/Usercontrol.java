package com.Tshirts.ekart.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Tshirts.ekart.dao.CategoryDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.model.Cart;
import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;
import com.Tshirts.ekart.model.User;
@Controller
public class Usercontrol {
	@Autowired
	 CategoryDao cd;
	 
	 @Autowired
	 ProductDao pd;
	 
	 @Autowired
	 UserDao userd;
	 
	 @RequestMapping("/products")
		public ModelAndView product(Model m,Principal p)
		{
		 if (p != null) {
			   User us = userd.getUserDetails(p.getName());
			   Cart cart = us.getCart();
			    m.addAttribute("cart",cart);
			   m.addAttribute(us);
			  }
			Product pr = new Product();
			m.addAttribute(pr);
			List<Product> listproducts = pd.retrieveAllProducts(); 
			m.addAttribute("prodlist",listproducts);
			List<Category> listcategories = cd.retrieveAllUsers();

			m.addAttribute("catlist", listcategories);


			return  new ModelAndView("userpage");
		}
	 @RequestMapping(value = "/productDisplay/{pid}", method = RequestMethod.GET)
	 public ModelAndView prodDisplay(@PathVariable("pid") int pid, Model m, Principal p) {
		 if (p != null) {
			   User us = userd.getUserDetails(p.getName());
			   Cart cart = us.getCart();
			    m.addAttribute("cart",cart);
			   m.addAttribute(us);
			  }
		 List<Category> listcategories = cd.retrieveAllUsers();
		 m.addAttribute("catlist", listcategories);
	  Product product = pd.getProduct(pid);
		m.addAttribute(product);
	  return new ModelAndView("productDisplay");
	 }
	 
	 @RequestMapping(value="/CategorizedProducts/{cid}", method = RequestMethod.GET)
	 public ModelAndView catproducts(@PathVariable("cid") int cid, Model m, Principal p) {
	  if (p != null) {
	   User us = userd.getUserDetails(p.getName());
	   Cart cart = us.getCart();
	    m.addAttribute("cart",cart);
	   m.addAttribute(us);
	  }
	  List<Category> listcategories = cd.retrieveAllUsers();
	  m.addAttribute("catlist", listcategories);
	  Category cat = cd.getCategory(cid);
	  Collection<Product> products = cat.getProd();
	  m.addAttribute("catprodlist", products);
	  return new ModelAndView("CategorizedProducts");
	 }



}
