package com.map.dto;


public class ProductDto {

	private String proname;
	private int price;
	
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ProductDto(String proname, int price) {
		super();
		this.proname = proname;
		this.price = price;
	}
	
}
