package com.Tshirts.ekart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	//@Pattern(regexp = "[a-zA-Z]{6,12}", message = "Only Alphabets in the range 6-12 are accepted")
	private String pname;
	@NotNull(message = "description should not be null")
	@NotEmpty(message = "description should not be empty")
	//@Pattern(regexp = "[a-zA-Z]{6,100}", message = "Only Alphabets in the range 6-100 are accepted")
	private String pdescription;
	@NotNull(message = "price should not be null")
	//@NotEmpty(message ="price should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private float price;
	@NotNull(message = "stock should not be null")
	//@NotEmpty(message ="stock should not be empty")
	//@Pattern(regexp = "[0-9]", message = "please fill this field")
	private int stock;
	@OneToOne
	private Category category;
	@Transient
	private MultipartFile image;
	
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
