package com.map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companyinformation")
public class Company {

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyid;
	@Column(name = "company_name")
	private String companyname;
	@Column(name = "company_address")
    private String companyaddress;
    
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getCompanyaddres() {
		return companyaddress;
	}
	public void setCompanyaddres(String companyaddres) {
		this.companyaddress = companyaddres;
	}
	
	
	
	
	
}
