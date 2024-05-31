
package com.kani.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Kani_ClassicalMedician")
public class ClassicalMedicines {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int cmId;
	private String Name, createdBy,updatedBy;
	@CreationTimestamp
	
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	@OneToMany(  fetch=FetchType.LAZY,  cascade=CascadeType.ALL)
    @JoinColumn( name="fk_cmId",referencedColumnName = "cmId")
private List<ClassicalMedicinesProducts> products;
 
	
	public ClassicalMedicines(){
		super();
	}


	public ClassicalMedicines(int cmId, String name, String createdBy, String updatedBy, Date createdDate,
			Date updatedDate) {
		super();
		this.cmId = cmId;
		Name = name;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}


	public int getCmId() {
		return cmId;
	}


	public void setCmId(int cmId) {
		this.cmId = cmId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
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
	

	

}