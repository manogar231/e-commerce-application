package com.map.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceid;
	@Column(name = "invoice_number")
	private String invoicenumber;
	@Column(name = "total")
	private Long total;
	@Column(name = "invoice_created")
	private LocalDate invoicecreated;
	@Column(name = "invoice_status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "company", referencedColumnName = "companyid")
	private Company company;
   
	@Column(columnDefinition = "json")
	private JsonArrayFormatVisitor productJson;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userid")
	private User user;
	
	
	public JsonArrayFormatVisitor getProductJson() {
		return productJson;
	}

	public void setProductJson(JsonArrayFormatVisitor productJson) {
		this.productJson = productJson;
	}

	public void invoicecreate() {
		this.invoicecreated = LocalDate.now();
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public LocalDate getInvoicecreated() {
		return invoicecreated;
	}

	public void setInvoicecreated(LocalDate invoicecreated) {
		this.invoicecreated = invoicecreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
