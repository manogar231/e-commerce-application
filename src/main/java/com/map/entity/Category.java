package com.map.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryid;
	@Column(name = "category_name")
	private String categoryname;
	@Column(name = "category_created")
	private LocalDate categorycreated;
	@Column(name = "category_updated")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date categoryupdate;

//	@OneToMany
//   @JoinColumn(name = "product_info",referencedColumnName = "productid")
//	private List<Product> product;

//	@PreUpdate
//	public void lastupdate() {
//		this.categoryupdate = LocalDate.now();
//	}

	public Category() {
		this.categorycreated = LocalDate.now();
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public Date getCategoryupdate() {
		return categoryupdate;
	}

	public void setCategoryupdate(Date categoryupdate) {
		this.categoryupdate = categoryupdate;
	}

	public LocalDate getCategorycreated() {
		return categorycreated;
	}

	public void setCategorycreated(LocalDate categorycreated) {
		this.categorycreated = categorycreated;
	}
}
