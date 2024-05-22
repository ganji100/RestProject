package com.kani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kani.entity.BrandProducts;
import com.kani.service.BrandProductsService;

@RestController
public class BrandProductsController {

	@Autowired
	BrandProductsService brandProductsService;

	@PostMapping("/registerBrandProduct")
	public ResponseEntity<String> saveBrandProduct(@RequestBody BrandProducts brandproducts) {
		try {
			brandProductsService.registerBrandProducts(brandproducts);
			return new ResponseEntity<>("BrandProducts registered successfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to register BrandProducts", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllBrandProducts")
	public ResponseEntity<List<BrandProducts>> getAllBrandProducts() {
		try {
			List<BrandProducts> brandProductsList = brandProductsService.getAllBrandProducts();
			return new ResponseEntity<>(brandProductsList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateBrandProduct")
	public ResponseEntity<String> updateBrandProduct(@RequestBody BrandProducts brandproducts) {
		try {
			brandProductsService.updateBrandProducts(brandproducts);
			return new ResponseEntity<>("BrandProducts updated successfully", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("BrandProducts not found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update BrandProducts", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteBrandProductsById/{id}")
	public ResponseEntity<String> deleteBrandProductsById(@PathVariable Long id) {
		try {
			brandProductsService.deleteBrandProductsById(id);
			return new ResponseEntity<>("BrandProducts deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete BrandProducts", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
