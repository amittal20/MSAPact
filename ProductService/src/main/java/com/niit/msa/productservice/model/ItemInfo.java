package com.niit.msa.productservice.model;


public class ItemInfo {

	private long itemid;
	private String name;
	private int price;
	private String category;
	public long getItemid() {
		return itemid;
	}
	public void setItemid(long itemId) {
		this.itemid = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ItemInfo(long itemInfo, String name, int price, String category) {
		super();
		this.itemid = itemInfo;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	public ItemInfo() {
		super();
	}
	@Override
	public String toString() {
		return "ItemInfo [itemid=" + itemid + ", name=" + name + ", price=" + price + ", category=" + category + "]";
	}
	
	
}
