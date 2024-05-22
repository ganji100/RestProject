package com.kani.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BrandProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double productPrice;
	private String productCreatedBy;
	@CreationTimestamp
	private Date productCreatedDate;
	@UpdateTimestamp
	private Date productModifiedDate;
	private String productModifiedBy;
	
	
	
	@ManyToOne
	@JoinColumn(name = "sub_brand_id", referencedColumnName = "subBrandId", 
	foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private SubBrands subBrands;
	
	public long getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCreatedBy() {
		return productCreatedBy;
	}
	public void setProductCreatedBy(String productCreatedBy) {
		this.productCreatedBy = productCreatedBy;
	}
	public Date getProductCreatedDate() {
		return productCreatedDate;
	}
	public void setProductCreatedDate(Date productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}
	public Date getProductModifiedDate() {
		return productModifiedDate;
	}
	public void setProductModifiedDate(Date productModifiedDate) {
		this.productModifiedDate = productModifiedDate;
	}
	public String getProductModifiedBy() {
		return productModifiedBy;
	}
	public void setProductModifiedBy(String productModifiedBy) {
		this.productModifiedBy = productModifiedBy;
	}
	
	
	public SubBrands getSubBrands() {
		return subBrands;
	}
	
   public  void setSubBrands(SubBrands subBrands) {
	this.subBrands=subBrands;
	
}
	
}
