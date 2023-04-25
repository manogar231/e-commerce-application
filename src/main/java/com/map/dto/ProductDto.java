package com.map.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ProductDto {

	private String productname;
	private int price;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public ProductDto(String productname, int price) {
		super();
		this.productname = productname;
		this.price = price;
	}
	
	 public ProductDto(String json) throws JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();
	        ProductDto productDto = objectMapper.readValue(json, ProductDto.class);
	        this.productname = productDto.productname;
	        this.price = productDto.price;
	    }
	
}
