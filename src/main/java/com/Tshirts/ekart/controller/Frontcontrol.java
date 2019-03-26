package com.Tshirts.ekart.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Tshirts.ekart.dao.CartDao;
import com.Tshirts.ekart.dao.CategoryDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.model.Cart;
import com.Tshirts.ekart.model.Category;
import com.Tshirts.ekart.model.Product;
import com.Tshirts.ekart.model.User;

@Controller
public class Frontcontrol {

	@Autowired
	UserDao userd;
	
	@Autowired
	CartDao cd;
	
	@Autowired
	 CategoryDao cg;
	
	@Autowired
	 ProductDao pd;


	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	 public ModelAndView homePage(Model m, Principal p) {
	  if (p != null) {
	  User us = userd.getUserDetails(p.getName());
	  System.out.println("i got:"+p.getName());
	   if (!us.getRole().equals("ROLE_ADMIN")) {
		   Cart cart = us.getCart();
		    m.addAttribute("cart",cart);
	    m.addAttribute("user", us);
	    return new ModelAndView("userpage");
	   }else {
	    System.out.println("not logged in");
	    return new ModelAndView("Adminpage");
	    
	   }
	   
	  }
	 
	  return new ModelAndView("index");
	}
	
	@RequestMapping("/signin")
	public String loginpage(Model m)
	{
		List<Product> listproducts = pd.retrieveAllProducts(); 
		m.addAttribute("prodlist",listproducts);
		List<Category> listcategories = cg.retrieveAllUsers();
		m.addAttribute("catlist", listcategories);
		return "login";
	}



	@RequestMapping("/reg")
	public ModelAndView reg(Model m) {
		User us = new User();
		m.addAttribute("user", us);
		return new ModelAndView("viewpage");
	}
	
	@RequestMapping("/signup")
	public String signupage(@Valid @ModelAttribute("user") User us , BindingResult result , Model m) throws Exception
	{
		if(result.hasErrors())
		{
			m.addAttribute("user", us);
			return "viewpage";
		}
		else {
			if(!us.getPassword().equals(us.getConfirmPassword()))
			{
					m.addAttribute(us);
					m.addAttribute("errorpass", "password should match");
					return "viewpage";
				}
			else
			{
				Cart cart = new Cart();
			     us.setCart(cart);
			     cart.setUser(us);
			     
				userd.addCreate(us);
				cd.add(cart);
				
				List<Category> listcategories = cg.retrieveAllUsers();
				m.addAttribute("catlist", listcategories);
				return "redirect:/";
			}
		}
			
	}
}
	
