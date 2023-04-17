package com.map.dto;

public class StatusDto {

	private  String status;
	
	public enum Status {
		ACTIVE,
		DEACTIVE,
		DELETED;
	}
	public  String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	
}
