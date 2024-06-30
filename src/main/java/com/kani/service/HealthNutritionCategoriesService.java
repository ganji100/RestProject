package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.HealthNutrutionCategories;
import com.kani.repo.HealthNutritionCategoriesRepository;
import com.kani.request.HealthNutritionCategoriesRequest;
import com.kani.response.HealthNutritionCategoriesResponse;

import jakarta.transaction.Transactional;

@Service
public class HealthNutritionCategoriesService {

    @Autowired
    HealthNutritionCategoriesRepository repo;

    @Transactional
    public HealthNutritionCategoriesResponse saveCategory(HealthNutritionCategoriesRequest request) {
        HealthNutritionCategoriesResponse response = new HealthNutritionCategoriesResponse();
        try {
            // Check if the category name already exists
            List<HealthNutrutionCategories> existingCategory = repo.findByCategoryName(request.getCategoryName());
            System.out.println(existingCategory);
            if (!existingCategory.isEmpty()) {
                response.setMessage("Category name already exists");
                response.setStatus("FAILURE");
                return response;
            }

            // Create new category
            HealthNutrutionCategories category = new HealthNutrutionCategories();
            category.setCategoryName(request.getCategoryName());

            repo.save(category);

            response.setHealthNutritionCategory(category);
            response.setMessage("Category saved successfully");
            response.setStatus("SUCCESS");

        } catch (Exception e) {
            response.setMessage("Error saving category: " + e.getMessage());
            response.setStatus("FAILURE");
        }
        return response;
    }

    public HealthNutritionCategoriesResponse findAllCategories() {
        HealthNutritionCategoriesResponse response = new HealthNutritionCategoriesResponse();
        List<HealthNutrutionCategories> categories = repo.findAll();
        response.setHealthNutritionCategories(categories);
        response.setMessage("Data fetched successfully");
        response.setStatus("SUCCESS");
        return response;
    }

    @Transactional
    public HealthNutritionCategoriesResponse updateCategory(HealthNutritionCategoriesRequest request) {
        HealthNutritionCategoriesResponse response = new HealthNutritionCategoriesResponse();
        try {
            HealthNutrutionCategories category = repo.findById(request.getCategoryId()).orElse(null);
            if (category != null) {
            	category.setCategoryId(request.getCategoryId());
                category.setCategoryName(request.getCategoryName());
				/*
				 * category.setCreatedBy(request.getCreatedBy());
				 * category.setUpdatedBy(request.getUpdatedBy());
				 */
                repo.save(category);
                response.setHealthNutritionCategory(category);
                response.setMessage("Category updated successfully");
                response.setStatus("SUCCESS");
            } else {
                response.setMessage("Category not found");
                response.setStatus("FAILURE");
            }
        } catch (Exception e) {
            response.setMessage("Error updating category: " + e.getMessage());
            response.setStatus("FAILURE");
        }
        return response;
    }

    @Transactional
    public HealthNutritionCategoriesResponse deleteCategory(Long id) {
        HealthNutritionCategoriesResponse response = new HealthNutritionCategoriesResponse();
        try {
            HealthNutrutionCategories category = repo.findById(id).orElse(null);
            if (category != null) {
                repo.delete(category);
                response.setMessage("Category deleted successfully");
                response.setStatus("SUCCESS");
            } else {
                response.setMessage("Category not found");
                response.setStatus("FAILURE");
            }
        } catch (Exception e) {
            response.setMessage("Error deleting category: " + e.getMessage());
            response.setStatus("FAILURE");
        }
        return response;
    }
}
