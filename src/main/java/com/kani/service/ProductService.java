package com.kani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.ClassicalMedicines;
import com.kani.entity.ClassicalMedicinesProducts;
import com.kani.repo.ClassicalMedicinesProductRepository;
import com.kani.repo.ClassicalMedicinesRepository;
import com.kani.request.ProductRequest;
import com.kani.response.ProductResponse;

@Service
public class ProductService {
	@Autowired
	ClassicalMedicinesRepository cmrepo;

	@Autowired
	ClassicalMedicinesProductRepository repo;

	public ProductResponse addProduct(ProductRequest req) {
		ProductResponse res = new ProductResponse();
		ClassicalMedicinesProducts cmp = new ClassicalMedicinesProducts();
		cmp.setProductName(req.getProductName());
		cmp.setPrice(req.getPrice());
      int cmId=req.getClassicalMedicines().getCmId();
      ClassicalMedicines cm=cmrepo.findById(cmId);
      cmp.setClassicalMedicines(cm);
		cmp.setCreatedBy(req.getCreatedBy());
		cmp.setUpdatedBy(req.getUpdatedBy());
		repo.save(cmp);
		res.setMessage("Successfully added product");
		res.setStatus("Successes");

		return res;
	}
	public ProductResponse fetchProducts() {
		ProductResponse res=new ProductResponse();
		List<ClassicalMedicinesProducts>list=new ArrayList<ClassicalMedicinesProducts>();
		List<ClassicalMedicinesProducts>db=repo.findAll();
				if (db.size() > 0) {
			for (ClassicalMedicinesProducts cm: db) {
				list.add(cm);
			}
			res.setAllProducts(list);
			res.setMessage("fetching data");
			res.setStatus("Successfully");
		}
		return res;
	}
	public ProductResponse deleteProduct(int id) {
		ProductResponse res=new ProductResponse();
			repo.deleteById(id);
			   res.setMessage("product  deleted");
			      res.setStatus("Success");
			      return res;
	}
	public ProductResponse updateProduct(ClassicalMedicinesProducts p) {
		ProductResponse res=new ProductResponse();
      repo.save(p);
      res.setMessage("Product Updated");
      res.setStatus("Success");
      return res;
	}
	
	
}

