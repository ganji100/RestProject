package com.kani.request;

import java.util.Date;

import com.kani.entity.ClassicalMedicines;

public class ClassicalMedicineProductRequest {
	private int productId;
	private String productName;
	private long price;
	private String createdBy;
	private String updatedBy;
	private Date createdDate;
	private Date updateddate;
	private ClassicalMedicines classicalMedicines;
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
	public ClassicalMedicines getClassicalMedicines() {
		return classicalMedicines;
	}
	public void setClassicalMedicines(ClassicalMedicines classicalMedicines) {
		this.classicalMedicines = classicalMedicines;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	
	
	

}


	