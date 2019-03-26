package com.Tshirts.ekart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	@NotNull(message = "name should not be null")
	@NotEmpty(message = "name should not be empty")
	//@Pattern(regexp = "[a-zA-Z]{6,12}", message = "Only Alphabets in the range 6-12 are accepted")
	private String cname;
	@NotNull(message = "description should not be null")
	@NotEmpty(message = "description should not be empty")
	//@Pattern(regexp = "[a-zA-Z]{6,100}", message = "Only Alphabets in the range 6-100 are accepted")
	private String cdescription;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="category")
	private Collection<Product> prod=new ArrayList<Product>();
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public Collection<Product> getProd() {
		return prod;
	}
	public void setProd(Collection<Product> prod) {
		this.prod = prod;
	}
	
	
}
