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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyid;
	@Column(name = "company_name")
	private String companyname;
	@Column(name = "company_address")
    private String companyaddres;
    
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
		return companyaddres;
	}
	public void setCompanyaddres(String companyaddres) {
		this.companyaddres = companyaddres;
	}
	
	
	
	
	
}
