package com.Tshirts.ekart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@NotNull(message = "quantity should not be null")
	//@NotEmpty(message ="quantity should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private int cquantity;
	@NotNull(message = "price should not be null")
	//@NotEmpty(message ="price should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private float cprice;
	@OneToOne
	private User user;
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItems> csi;
	public List<CartItems> getCsi() {
		return csi;
	}
	public void setCsi(List<CartItems> csi) {
		this.csi = csi;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCquantity() {
		return cquantity;
	}
	public void setCquantity(int cquantity) {
		this.cquantity = cquantity;
	}
	public float getCprice() {
		return cprice;
	}
	public void setCprice(float f) {
		this.cprice = f;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
