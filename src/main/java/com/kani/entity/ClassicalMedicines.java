
package com.kani.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "Kani_ClassicalMedicines")
public class ClassicalMedicines {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int classicalMedicineId;
	private String classicalMedicineName, createdBy, updatedBy;

	@CreationTimestamp

	@Column(updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	private Date updatedDate;

	@OneToMany(cascade = CascadeType.ALL)

	@JoinColumn(name = "fk_cmId", referencedColumnName = "classicalMedicineId")
	private List<ClassicalMedicinesProducts> products;

	public ClassicalMedicines() {
		super();
	}

	public ClassicalMedicines(int cmclassicalMedicineIdId, String classicalMedicineName, String createdBy,
			String updatedBy, Date createdDate, Date updatedDate) {
		super();
		this.classicalMedicineId = classicalMedicineId;
		classicalMedicineName = classicalMedicineName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public int getClassicalMedicineId() {
		return classicalMedicineId;
	}

	public void setClassicalMedicineId(int classicalMedicineId) {
		this.classicalMedicineId = classicalMedicineId;
	}

	public String getClassicalMedicineName() {
		return classicalMedicineName;
	}

	public void setClassicalMedicineName(String classicalMedicineName) {
		this.classicalMedicineName = classicalMedicineName;
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

	public List<ClassicalMedicinesProducts> getProducts() {
		return products;
	}

	public void setProducts(List<ClassicalMedicinesProducts> products) {
		this.products = products;
	}

}
