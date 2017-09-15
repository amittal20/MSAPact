package com.niit.msa.iteminvoice.modal;

import java.io.Serializable;

public class Product implements Serializable{
	
	private long itemid;
	
	private String productName;
	
	private String reviews;

	public long getItemid() {
		return itemid;
	}

	public void setItemid(long itemid) {
		this.itemid = itemid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [itemid=" + itemid + ", productName=" + productName + ", reviews=" + reviews + "]";
	}
	
	
	
}
