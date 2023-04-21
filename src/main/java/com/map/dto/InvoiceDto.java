package com.map.dto;

import java.util.List;

public class InvoiceDto {

	
	private String username;
	private List<ProductDto> product;	
	private int total;
	private int companyid;
	
	
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
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	
}
