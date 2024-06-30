
package com.kani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kani.request.HealthAndNutritionProductsRequest;
import com.kani.response.HealthNutritionProductsResponse;
import com.kani.service.HealthNutritionProductsService;

@RestController

@RequestMapping("/products")
public class HealthNutritionProductsController {

	@Autowired
	HealthNutritionProductsService productService;

	@GetMapping("/list")
	public ResponseEntity<HealthNutritionProductsResponse> listProducts() {
		HealthNutritionProductsResponse response = productService.findAllProducts();
		return ResponseEntity.ok(response);
	}

	@PostMapping("/save")
	public ResponseEntity<HealthNutritionProductsResponse> saveProduct(
			@RequestBody HealthAndNutritionProductsRequest product) {
		HealthNutritionProductsResponse response = productService.saveProduct(product);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/update")
	public ResponseEntity<HealthNutritionProductsResponse> updateProduct(
			@RequestBody HealthAndNutritionProductsRequest product) {
		HealthNutritionProductsResponse response = productService.updateProduct(product);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HealthNutritionProductsResponse> deleteProduct(@PathVariable Long id) {
		HealthNutritionProductsResponse response = productService.deleteProduct(id);
		return ResponseEntity.ok(response);
	}
}
