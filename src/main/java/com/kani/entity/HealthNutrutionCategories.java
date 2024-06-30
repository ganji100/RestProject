package com.kani.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "healthNutritionCategories")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthNutrutionCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(unique = true)
    private String categoryName;
	/*
	 * private String createdBy; private String updatedBy;
	 */
   

	@OneToMany( targetEntity = HealthNutritionProducts.class, cascade = CascadeType.ALL)
	@JoinColumn(name="category_id",referencedColumnName = "categoryId")
	 @JsonManagedReference
    private List<HealthNutritionProducts> products;

    // Getters and Setters

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<HealthNutritionProducts> getProducts() {
        return products;
    }

    public void setProducts(List<HealthNutritionProducts> products) {
        this.products = products;
    }
	/*
	 * public String getCreatedBy() { return createdBy; }
	 * 
	 * public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	 * 
	 * public String getUpdatedBy() { return updatedBy; }
	 * 
	 * public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
	 */
}
