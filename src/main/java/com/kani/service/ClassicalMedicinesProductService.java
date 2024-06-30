
package com.kani.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kani.entity.ClassicalMedicines;
import com.kani.entity.ClassicalMedicinesProducts;
import com.kani.repo.ClassicalMedicinesProductRepository;
import com.kani.repo.ClassicalMedicinesRepository;
import com.kani.request.ClassicalMedicineProductRequest;
import com.kani.response.ClassicalMedicinesProductResponse;

@Service
public class ClassicalMedicinesProductService {

	@Autowired
	ClassicalMedicinesRepository cmrepo;

	@Autowired
	ClassicalMedicinesProductRepository repo;

	public ClassicalMedicinesProductResponse addProduct(ClassicalMedicineProductRequest request, MultipartFile file)
			throws IOException {
		ClassicalMedicinesProductResponse response = new ClassicalMedicinesProductResponse();
		ClassicalMedicinesProducts products = new ClassicalMedicinesProducts();
		products.setProductName(request.getProductName());
		products.setPrice(request.getPrice());
		int classiclaMedicineId = request.getClassicalMedicines().getClassicalMedicineId();
		ClassicalMedicines classicalMedicine = cmrepo.findById(classiclaMedicineId);
		products.setClassicalMedicines(classicalMedicine);

		products.setCreatedBy(request.getCreatedBy());
		products.setUpdatedBy(request.getUpdatedBy());
		if (file != null && !file.isEmpty()) {
			products.setImage(file.getBytes());
		} else {
			throw new IllegalArgumentException("Image file is required");
		}

		repo.save(products);
		response.setMessage("Successfully added product");
		response.setStatus("Successes");

		return response;
	}

	public ClassicalMedicinesProductResponse fetchProducts() {
		ClassicalMedicinesProductResponse response = new ClassicalMedicinesProductResponse();
		List<ClassicalMedicinesProducts> list = new ArrayList<ClassicalMedicinesProducts>();
		List<ClassicalMedicinesProducts> db = repo.findAll();
		if (db.size() > 0) {
			for (ClassicalMedicinesProducts cm : db) {
				list.add(cm);
			}
			response.setAllProducts(list);
			response.setMessage("fetching the data from the database");
			response.setStatus("Successfully");
		}
		return response;
	}

	public ClassicalMedicinesProductResponse deleteProduct(int id) {
		ClassicalMedicinesProductResponse response = new ClassicalMedicinesProductResponse();
		repo.deleteById(id);
		response.setMessage("product is deleted");
		response.setStatus("Success");
		return response;
	}

	public ClassicalMedicinesProductResponse updateProduct(ClassicalMedicinesProducts product, MultipartFile file)
			throws IOException {
		ClassicalMedicinesProductResponse response = new ClassicalMedicinesProductResponse();
		int ProductId = product.getProductId();
		ClassicalMedicinesProducts existingProduct = repo.findById(ProductId);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCreatedBy(product.getCreatedBy());
		existingProduct.setUpdatedBy(product.getUpdatedBy());
		if (file != null && !file.isEmpty()) {
			product.setImage(file.getBytes());
		} else {
			throw new IllegalArgumentException("Image file is required");
		}
		repo.save(product);
		response.setMessage("Product is  Updated");
		response.setStatus("Success");
		return response;
	}

}
