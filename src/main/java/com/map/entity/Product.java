package com.map.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proid;
	@Column(name = "pro_name")
	private String proname;
	@Column(name = "price")
	private int price;
	@Column(name = "status")
	private String status;
	@Column(name = "product_created")
	private LocalDate productcreated;
	@Column(name = "product_updated")
	@Temporal(TemporalType.DATE)
	private LocalDate productupdated;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="category_info" ,referencedColumnName = "categoryid")
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@PreUpdate
	public void latestProductUpdate() {
		this.productupdated = LocalDate.now();
	}

	public Product() {
		this.productcreated = LocalDate.now();
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getProductupdated() {
		return productupdated;
	}

	public void setProductupdated(LocalDate productupdated) {
		this.productupdated = productupdated;
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

}
