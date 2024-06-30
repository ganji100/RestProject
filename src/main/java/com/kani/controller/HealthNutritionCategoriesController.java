package com.kani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kani.request.HealthNutritionCategoriesRequest;
import com.kani.response.HealthNutritionCategoriesResponse;
import com.kani.service.HealthNutritionCategoriesService;

@RestController
@RequestMapping("/category")
public class HealthNutritionCategoriesController {

    @Autowired
    HealthNutritionCategoriesService categoriesService;

    @PostMapping("/save")
    public ResponseEntity<HealthNutritionCategoriesResponse> createCategory(@RequestBody HealthNutritionCategoriesRequest request) {
        HealthNutritionCategoriesResponse response = categoriesService.saveCategory(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<HealthNutritionCategoriesResponse> listCategories() {
        HealthNutritionCategoriesResponse response = categoriesService.findAllCategories();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<HealthNutritionCategoriesResponse> updateCategory(@RequestBody HealthNutritionCategoriesRequest request) {
        HealthNutritionCategoriesResponse response = categoriesService.updateCategory(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HealthNutritionCategoriesResponse> deleteCategory(@PathVariable Long id) {
        HealthNutritionCategoriesResponse response = categoriesService.deleteCategory(id);
        return ResponseEntity.ok(response);
    }
}
