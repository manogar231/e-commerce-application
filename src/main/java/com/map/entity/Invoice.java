package com.map.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.map.util.InvoiceStatus;

@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceid;
	@Column(name = "invoice_number")
	private String invoicenumber;
	@Column(name = "total")
	private int total;
	@Column(name = "invoice_created")
	@CreatedDate
	private LocalDate invoicecreated;
	@Column(name = "invoice_status")
	@Enumerated(value = EnumType.STRING)
	private InvoiceStatus status;

	@ManyToOne
	@JoinColumn(name = "company", referencedColumnName = "companyid")
	private Company company;
    
	@Column(columnDefinition = "json")
	private String productJson;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "userid")
	private User user;
	
	 public  void Invoices() {	
     	this.invoicecreated=LocalDate.now();
	};
	public String getProductJson() {
		return productJson;
	}

	public void setProductJson(String string) {
		this.productJson = string;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDate getInvoicecreated() {
		return invoicecreated;
	}

	public void setInvoicecreated(LocalDate invoicecreated) {
		this.invoicecreated = invoicecreated;
	}
	public InvoiceStatus getStatus() {
		return status;
	}
	public void setStatus(InvoiceStatus status) {
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
	
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", invoicenumber=" + invoicenumber + ", total=" + total
				+ ", invoicecreated=" + invoicecreated + ", status=" + status + ", company=" + company
				+ ", productJson=" + productJson + ", user=" + user + "]";
	}
	public Invoice(int invoiceid, String invoicenumber, int total, LocalDate invoicecreated, InvoiceStatus status,
			Company company, String productJson, User user) {
		super();
		this.invoiceid = invoiceid;
		this.invoicenumber = invoicenumber;
		this.total = total;
		this.invoicecreated = invoicecreated;
		this.status = status;
		this.company = company;
		this.productJson = productJson;
		this.user = user;
	}
	public Invoice() {
		super();
		
	}
	
}
