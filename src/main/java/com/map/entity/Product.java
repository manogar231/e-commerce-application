package com.map.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	@Column(name = "product_name")
	private String productname;
	@Column(name = "price")
	private int price;
	@Column(name = "status")
	private String status;
	@Column(name = "product_created")
	private LocalDate productcreated;
	@Column(name = "product_updated")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date productupdated;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_info" ,referencedColumnName = "categoryid")
	private Category category;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getProductcreated() {
		return productcreated;
	}

	public void setProductcreated(LocalDate productcreated) {
		this.productcreated = productcreated;
	}
	public Date getProductupdated() {
		return productupdated;
	}

	public void setProductupdated(Date productupdated) {
		this.productupdated = productupdated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
