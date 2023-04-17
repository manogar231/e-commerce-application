package com.map.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "invoice")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceid;
	@Column(name = "invoice_number")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoicenumber;
	@Column(name = "total")
	private Long total;
	@Column(name = "invoice_created")
	private LocalDate invoicecreated;
	
	@ManyToOne
	@JoinColumn(name = "company", referencedColumnName = "companyid")
	private Company company;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id",referencedColumnName = "userid")
	private User user;
	
    @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "product_id",referencedColumnName = "proid")
    private Product product;
	
	public void invoicecreate() {
		this.invoicecreated = LocalDate.now();
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Long getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(Long invoicenumber) {
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

}
