
package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.HealthNutritionProducts;
import com.kani.entity.HealthNutrutionCategories;
import com.kani.repo.HealthNutritionCategoriesRepository;
import com.kani.repo.HealthNutritionProductsRepository;
import com.kani.request.HealthAndNutritionProductsRequest;
import com.kani.response.HealthNutritionProductsResponse;

import jakarta.transaction.Transactional;

@Service
public class HealthNutritionProductsService {

	@Autowired
	HealthNutritionProductsRepository repo;
	
	@Autowired
	HealthNutritionCategoriesRepository categoryRepo;

	@Transactional
	public HealthNutritionProductsResponse saveProduct(HealthAndNutritionProductsRequest request) {
		HealthNutritionProductsResponse response = new HealthNutritionProductsResponse();
		try {
			 List<HealthNutrutionCategories> categories = categoryRepo.findByCategoryName(request.getHealthNutritionCategory().getCategoryName());
	            if (categories.size() == 1) {
	                HealthNutritionProducts product = new HealthNutritionProducts();

	                product.setProductId(request.getProductId());
	                product.setProductName(request.getProductName());
	                product.setCreatedBy(request.getCreatedBy());
	                product.setProductPrice(request.getProductPrice());
	                product.setUpdatedBy(request.getUpdatedBy());
	                product.setHealthNutritionCategory(categories.get(0));

	                repo.save(product);

	                response.setMessage("Product saved successfully");
	                response.setStatus("SUCCESS");
	            } else if (categories.size() == 0) {
	                response.setMessage("Error: Category not found");
	                response.setStatus("FAILURE");
	            } else {
	                response.setMessage("Error: Multiple categories found");
	                response.setStatus("FAILURE");
	            }			
			 
		} catch (Exception e) {
			response.setMessage("Error saving product: " + e.getMessage());
			response.setStatus("FAILURE");
		}
		return response;
	}

	public HealthNutritionProductsResponse findAllProducts() {
		HealthNutritionProductsResponse response = new HealthNutritionProductsResponse();
		try {
			List<HealthNutritionProducts> products = repo.findAll();
			response.setListProducts(products);
			response.setMessage("Products fetched successfully");
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			response.setMessage("Error fetching products: " + e.getMessage());
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Transactional
	public HealthNutritionProductsResponse updateProduct(HealthAndNutritionProductsRequest request) {
		HealthNutritionProductsResponse response = new HealthNutritionProductsResponse();
		try {
			HealthNutritionProducts product = new HealthNutritionProducts();
			product.setProductId(request.getProductId());
			product.setProductName(request.getProductName());
			product.setCreatedBy(request.getCreatedBy());
			product.setProductPrice(request.getProductPrice());
			product.setUpdatedBy(request.getUpdatedBy());
			product.setHealthNutritionCategory(request.getHealthNutritionCategory());
			HealthNutritionProducts existingProduct = repo.findById(product.getProductId()).get();
			if (existingProduct != null) {
				repo.save(product);
				response.setMessage("Product updated successfully");
				response.setStatus("SUCCESS");
			} else {
				response.setMessage("Product not found");
				response.setStatus("FAILURE");
			}
		} catch (Exception e) {
			response.setMessage("Error updating product: " + e.getMessage());
			response.setStatus("FAILURE");
		}
		return response;
	}

	@Transactional
	public HealthNutritionProductsResponse deleteProduct(Long id) {
		HealthNutritionProductsResponse response = new HealthNutritionProductsResponse();
		try {
			HealthNutritionProducts product = repo.findById(id).orElse(null);
			if (product != null) {
				repo.delete(product);
				response.setMessage("Product deleted successfully");
				response.setStatus("SUCCESS");
			} else {
				response.setMessage("Product not found");
				response.setStatus("FAILURE");
			}
		} catch (Exception e) {
			response.setMessage("Error deleting product: " + e.getMessage());
			response.setStatus("FAILURE");
		}
		return response;
	}
}
