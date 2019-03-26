package com.Tshirts.ekart.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class CartItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ciid;
	@NotNull(message = "quantity should not be null")
	//@NotEmpty(message ="quantity should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private int ciquantity;
	@NotNull(message = "price should not be null")
	//@NotEmpty(message ="price should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private float ciprice;
	@OneToOne(fetch=FetchType.EAGER)
	private Product prod;
	@ManyToOne
	private Cart cart;
	public int getCiid() {
		return ciid;
	}
	public void setCiid(int ciid) {
		this.ciid = ciid;
	}
	public int getCiquantity() {
		return ciquantity;
	}
	public void setCiquantity(int ciquantity) {
		this.ciquantity = ciquantity;
	}
	public float getCiprice() {
		return ciprice;
	}
	public void setCiprice(float f) {
		this.ciprice = f;
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

}
