package com.Tshirts.ekart.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class User {
	public static final String DEFAULT_ROLE = "ROLE_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	//@Pattern(regexp = "[a-zA-Z]{6,12}", message = "Only Alphabets in the range 6-12 are accepted")
	private String name;
	@NotNull(message="number should not be null")
	//@Pattern(regexp="[0-9]{10,10}",message="only 10 numbers are accepted")
	private String mobileno;
	@NotNull(message = "address should not be blank")
	private String address;
	@NotNull(message = "email should not be blank")
	//@Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@"
	//+ "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$", message = "you can use @symbol , hiphen- and digits")
	private String emailid;
	@NotNull(message = "password should not be left blank")
	//@Pattern(regexp = "((?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{8,12})", message = "One UpperCase, One lowercase, one number and one special character are must in 8-12 character range")
	private String password;
	@Transient
	private String confirmPassword;
	private boolean is_Active;
	private String role = DEFAULT_ROLE;
	@ManyToOne
	private Cart cart;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isIs_Active() {
		return is_Active;
	}
	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static String getDefaultRole() {
		return DEFAULT_ROLE;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	

}
