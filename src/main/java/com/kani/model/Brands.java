package com.kani.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Brands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long brandId;
	private String brandName;
	@CreationTimestamp
	private Date brandCreatedDate;
	@UpdateTimestamp
	private Date brandUpdatedDate;
	private String brandCreatedBy;
	private String brandUpdatedBy;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SubBrands> subBrands;

	public Brands(String brandName, String brandCreatedBy, String brandUpdatedBy) {
		super();
		this.brandName = brandName;
		this.brandCreatedBy = brandCreatedBy;
		this.brandUpdatedBy = brandUpdatedBy;
	}

	public Brands() {
		// TODO Auto-generated constructor stub
	}

	public long getBrandId() {
		return brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getBrandCreatedDate() {
		return brandCreatedDate;
	}

	public void setBrandCreatedDate(Date brandCreatedDate) {
		this.brandCreatedDate = brandCreatedDate;
	}

	public Date getBrandUpdatedDate() {
		return brandUpdatedDate;
	}

	public void setBrandUpdatedDate(Date brandUpdatedDate) {
		this.brandUpdatedDate = brandUpdatedDate;
	}

	public String getBrandCreatedBy() {
		return brandCreatedBy;
	}

	public void setBrandCreatedBy(String brandCreatedBy) {
		this.brandCreatedBy = brandCreatedBy;
	}

	public String getBrandUpdatedBy() {
		return brandUpdatedBy;
	}

	public void setBrandUpdatedBy(String brandUpdatedBy) {
		this.brandUpdatedBy = brandUpdatedBy;
	}

	@Override
	public String toString() {
		return "Brands [brandId=" + brandId + ", brandName=" + brandName + ", brandCreatedDate=" + brandCreatedDate
				+ ", brandUpdatedDate=" + brandUpdatedDate + ", brandCreatedBy=" + brandCreatedBy + ", brandUpdatedBy="
				+ brandUpdatedBy + "]";
	}

}
