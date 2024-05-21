package com.kani.model;

import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SubBrands {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subBrandId;

	private String subBrandName;
	private String subBrandCreatedBy;
	@CreationTimestamp
	private Date subBrandCreatedDate;
	private String subBrandUpdatedBy;
	@UpdateTimestamp
	private Date subBrandUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "brandId", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Brands brands;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<BrandProducts> brandProducts;

	public Long getSubBrandId() {
		return subBrandId;
	}

	public void setSubBrandId(Long subBrandId) {
		this.subBrandId = subBrandId;
	}

	public String getSubBrandName() {
		return subBrandName;
	}

	public void setSubBrandName(String subBrandName) {
		this.subBrandName = subBrandName;
	}

	public String getSubBrandCreatedBy() {
		return subBrandCreatedBy;
	}

	public void setSubBrandCreatedBy(String subBrandCreatedBy) {
		this.subBrandCreatedBy = subBrandCreatedBy;
	}

	public Date getSubBrandCreatedDate() {
		return subBrandCreatedDate;
	}

	public void setSubBrandCreatedDate(Date subBrandCreatedDate) {
		this.subBrandCreatedDate = subBrandCreatedDate;
	}

	public String getSubBrandUpdatedBy() {
		return subBrandUpdatedBy;
	}

	public void setSubBrandUpdatedBy(String subBrandUpdatedBy) {
		this.subBrandUpdatedBy = subBrandUpdatedBy;
	}

	public Date getSubBrandUpdatedDate() {
		return subBrandUpdatedDate;
	}

	public void setSubBrandUpdatedDate(Date subBrandUpdatedDate) {
		this.subBrandUpdatedDate = subBrandUpdatedDate;
	}

	public Brands getBrands() {
		return brands;
	}

	public void setBrands(Brands brands) {
		this.brands = brands;
	}
}
