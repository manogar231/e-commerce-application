package com.map.dto;

import java.util.List;

public class InvoiceDto {

	
	private String username;
	private List<ProductDto> product;	
	private int total;
	private String companyname;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<ProductDto> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDto> product) {
		this.product = product;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	
	
	
	
}
