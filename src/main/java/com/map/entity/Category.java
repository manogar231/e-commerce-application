package com.map.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
//	@Temporal(TemporalType.DATE)
	private LocalDate categoryupdate;

//	@OneToMany
//   @JoinColumn(name = "product_info",referencedColumnName = "productid")
//	private List<Product> product;

	@PreUpdate
	public void lastupdate() {
		this.categoryupdate = LocalDate.now();
	}

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

	public LocalDate getCategoryupdate() {
		return categoryupdate;
	}

	public void setCategoryupdate(LocalDate categoryupdate) {
		this.categoryupdate = categoryupdate;
	}

	public LocalDate getCategorycreated() {
		return categorycreated;
	}

	public void setCategorycreated(LocalDate categorycreated) {
		this.categorycreated = categorycreated;
	}
}
