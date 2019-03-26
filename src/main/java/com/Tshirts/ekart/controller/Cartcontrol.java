package com.Tshirts.ekart.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tshirts.ekart.dao.CartDao;
import com.Tshirts.ekart.dao.CartItemsDao;
import com.Tshirts.ekart.dao.ProductDao;
import com.Tshirts.ekart.dao.UserDao;
import com.Tshirts.ekart.model.Cart;
import com.Tshirts.ekart.model.CartItems;
import com.Tshirts.ekart.model.Product;
import com.Tshirts.ekart.model.User;

@Controller
@RequestMapping("/customer")
public class Cartcontrol {
	
	@Autowired
	ProductDao pd;
	
	@Autowired
	UserDao ud;
	
	@Autowired
	CartDao cd;
	
	@Autowired
	CartItemsDao cid;
	
	@RequestMapping("/addToCart/{pid}")
	 public String addToCart(@PathVariable("pid") int pid, Model m, @RequestParam(value ="quantity") int quantity, Principal principal)
	 {
		
		System.out.println(principal);
		Product product = pd.getProduct(pid);
		  User us = ud.getUserDetails(principal.getName());
		  Cart cart = us.getCart();
		  
		  CartItems cartItems =  cid.getProduct(pid, cart.getCid());
		  if(cartItems==null)
		  {
		   cartItems = new CartItems();
		   cartItems.setProd(product);
		   cartItems.setCiquantity(quantity);
		   cartItems.setCart(cart);
		   cartItems.setCiprice(cartItems.getCiquantity() * product.getPrice());
		   ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		   itemsList.add(cartItems);
		   cart.setCquantity(cart.getCquantity()+cartItems.getCiquantity());
		   cart.setCprice(cart.getCprice()+cartItems.getCiprice());
		   cart.setCsi(itemsList);
		   m.addAttribute("cartItems",itemsList);
		   cid.add(cartItems);
		  }
		  else
		  {
		   cartItems.setProd(product);
		   cartItems.setCiprice(cartItems.getCiprice()+(quantity*product.getPrice()));
		   cartItems.setCiquantity(cartItems.getCiquantity()+quantity);
		   ArrayList<CartItems> itemsList=new ArrayList<CartItems>();
		   itemsList.add(cartItems);
		   cart.setCquantity(cart.getCquantity()+cartItems.getCiquantity());
		   cart.setCprice(cart.getCprice()+quantity*product.getPrice());
		   cart.setCsi(itemsList);
		   m.addAttribute("cartItems",itemsList);
		   cid.update(cartItems);
		  }
		  cd.update(cart);
		  m.addAttribute(product);
		  m.addAttribute(cart);
		  return "redirect:/customer/myCart";
	 }
	@RequestMapping("/myCart")
	 public String myCart(Model m, Principal principal)
	 {
	  System.out.println(principal);
	  User us=ud.getUserDetails(principal.getName());
	  Cart cart = us.getCart();
	  List<CartItems> cartItems = cart.getCsi();
	  m.addAttribute("cartItems",cartItems);
	  m.addAttribute(cart);
	  return "mycart";
	 }
	
	@RequestMapping(value="/editCartItems/{ciid}")
	 public String editcartItem(@PathVariable(value="ciid")int ciid, Model m, @RequestParam(value ="quantity") int quantity, Principal p)
	 {

	  CartItems cartItem = cid.get(ciid);
	  User us = ud.getUserDetails(p.getName());
	  Cart cart = us.getCart();
	  cart.setCquantity(cart.getCquantity()-cartItem.getCiquantity());
	  cart.setCprice(cart.getCprice()-cartItem.getCiprice());
	  Product product = cartItem.getProd();
	  cartItem.setCiquantity(quantity);
	  cartItem.setCiprice(quantity*product.getPrice());
	  cart.setCid(cartItem.getCart().getCid());
	  cart.setCquantity(cart.getCquantity()+cartItem.getCiquantity());
	  cart.setCprice(cart.getCprice()+cartItem.getCiprice());
	  cid.update(cartItem);
	  us.setCart(cart);
	  cd.update(cart);
	  return "redirect:/customer/myCart";
	  
	 }
	
	@RequestMapping(value="deleteCartItems/{ciid}/cartItem")
	 public String deleteCartItem(@PathVariable("ciid")int ciid,Model m, Principal p)
	 {
	  CartItems cartItem = cid.get(ciid);
	  User us = ud.getUserDetails(p.getName());
	  Cart cart = us.getCart();
	  cart.setCid(cartItem.getCart().getCid());
	     cart.setCquantity(cart.getCquantity()-cartItem.getCiquantity());
	     cart.setCprice(cart.getCprice()-cartItem.getCiprice());
	      us.setCart(cart);
	   cd.update(cart);
	  cid.delete(cartItem);
	  
	  return "redirect:/customer/myCart";
	 }
	 
	

}
