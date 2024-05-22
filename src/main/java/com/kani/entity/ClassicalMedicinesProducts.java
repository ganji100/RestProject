package com.kani.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ClassicalMedicines_Products")
public class ClassicalMedicinesProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int productId;
	private String productName;
	private long price;
	private String createdBy;
	private String updatedBy;
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
    private Date updatedDate;

	@ManyToOne(targetEntity = ClassicalMedicines.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_cmId", referencedColumnName = "cmId")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

	private ClassicalMedicines classicalMedicines;

	public ClassicalMedicinesProducts() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	
//	  public List<ClassicalMedicines> getMedicines() { return medicines; }
//	  
//	  public void setMedicines(List<ClassicalMedicines> medicines) { this.medicines
//	  = medicines; }
	 
	public ClassicalMedicines getClassicalMedicines() {
		return  classicalMedicines;
	}
	public void   setClassicalMedicines(ClassicalMedicines classicalMedicines) {
		this.classicalMedicines = classicalMedicines;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	

}
