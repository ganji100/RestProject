package com.kani.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kani.entity.ClassicalMedicinesProducts;
import com.kani.request.ClassicalMedicineProductRequest;
import com.kani.response.ClassicalMedicinesProductResponse;
import com.kani.service.ClassicalMedicinesProductService;

@RestController
@RequestMapping("/ClassicalMedicineproduct")
public class ClassicalMedicineProductController {
	@Autowired
	ClassicalMedicinesProductService service;
	
	@PostMapping(value = "/addClassicalMedicineproduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassicalMedicinesProductResponse> addProduct(@RequestPart("request") ClassicalMedicineProductRequest request,
			        @RequestPart("file") MultipartFile file) throws IOException{
		ClassicalMedicinesProductResponse response = new ClassicalMedicinesProductResponse();
	response = service.addProduct(request, file);
	return new ResponseEntity<>(response, HttpStatus.OK);
		}

	@GetMapping("/fetchClassicalMedicineproduct")
	public ResponseEntity<ClassicalMedicinesProductResponse>getProducts(){
		ClassicalMedicinesProductResponse res=new ClassicalMedicinesProductResponse();
		res=service.fetchProducts();
		return new ResponseEntity<>(res,HttpStatus.OK);

	}
	@DeleteMapping("/deleteClassicalMedicineproduct/{id}")
	public ResponseEntity<ClassicalMedicinesProductResponse>deleteProducts(@PathVariable int id){
		ClassicalMedicinesProductResponse response=new ClassicalMedicinesProductResponse();
		response=service.deleteProduct(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PutMapping("/updateClassicalMedicineproduct")
	public ResponseEntity<ClassicalMedicinesProductResponse>updateProducts(@RequestPart("product") ClassicalMedicinesProducts Products ,
	        @RequestPart("file") MultipartFile file) throws IOException{
		ClassicalMedicinesProductResponse response=new ClassicalMedicinesProductResponse();
		response=service.updateProduct(Products,file);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	
	

}
