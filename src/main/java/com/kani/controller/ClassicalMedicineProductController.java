package com.kani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kani.entity.ClassicalMedicinesProducts;
import com.kani.request.ClassicalMedicineProductRequest;
import com.kani.response.ProductResponse;
import com.kani.service.ProductService;

@RestController
@RequestMapping("/product")
public class ClassicalMedicineProductController {
	@Autowired
	ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<ProductResponse> saveProducts(@RequestBody ClassicalMedicineProductRequest request) throws Exception{
		ProductResponse response=new ProductResponse();
		response=service.addProduct(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@GetMapping("/fetchProducts")
	public ResponseEntity<ProductResponse>getProducts(){
		ProductResponse res=new ProductResponse();
		res=service.fetchProducts();
		return new ResponseEntity<>(res,HttpStatus.OK);

	}
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<ProductResponse>deleteProducts(@PathVariable int id){
		ProductResponse response=new ProductResponse();
		response=service.deleteProduct(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PutMapping("/updateMedicine")
	public ResponseEntity<ProductResponse>updateProducts(@RequestBody  ClassicalMedicinesProducts p){
		ProductResponse response=new ProductResponse();
		response=service.updateProduct(p);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	

}
