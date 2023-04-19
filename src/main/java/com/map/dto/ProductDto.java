package com.map.dto;


public class ProductDto {

	private String productname;
	private int price;
	
	public String getProname() {
		return productname;
	}
	public void setProname(String proname) {
		this.productname = proname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ProductDto(String proname, int price) {
		super();
		this.productname = proname;
		this.price = price;
	}
	
}
