package com.kani.request;

import com.kani.entity.HealthNutrutionCategories;

public class HealthAndNutritionProductsRequest {

    private Long productId;
    private String productName;
    public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	private Float productPrice;
    private String updatedBy;
    private String createdBy;
    private HealthNutrutionCategories healthNutritionCategory;
   
	public HealthNutrutionCategories getHealthNutritionCategory() {
		return healthNutritionCategory;
	}
	public void setHealthNutritionCategory(HealthNutrutionCategories healthNutritionCategory) {
		this.healthNutritionCategory = healthNutritionCategory;
	}
}
