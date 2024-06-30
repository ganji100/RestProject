package com.kani.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kani.entity.HealthNutrutionCategories;

public class HealthNutritionCategoriesResponse {

	@JsonInclude(JsonInclude.Include.NON_NULL)
    private HealthNutrutionCategories healthNutritionCategory;
    @JsonInclude(JsonInclude.Include.NON_NULL)    
    private List<HealthNutrutionCategories> healthNutritionCategories;
    private String message;
    private String status;

    // Getters and setters

    public HealthNutrutionCategories getHealthNutritionCategory() {
        return healthNutritionCategory;
    }

    public void setHealthNutritionCategory(HealthNutrutionCategories healthNutritionCategory) {
        this.healthNutritionCategory = healthNutritionCategory;
    }

    public List<HealthNutrutionCategories> getHealthNutritionCategories() {
        return healthNutritionCategories;
    }

    public void setHealthNutritionCategories(List<HealthNutrutionCategories> healthNutritionCategories) {
        this.healthNutritionCategories = healthNutritionCategories;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

