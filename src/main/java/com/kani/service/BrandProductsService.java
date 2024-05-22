package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.BrandProducts;
import com.kani.entity.SubBrands;
import com.kani.repo.BrandProductsRepository;
import com.kani.repo.SubBrandsRepository;

@Service
public class BrandProductsService {

	@Autowired
	BrandProductsRepository brandProductsRepo;

	@Autowired
	SubBrandsRepository subBrandRepository;

	public void registerBrandProducts(BrandProducts brandProducts) {
		
		Long subBrandId = brandProducts.getSubBrands().getSubBrandId();

		SubBrands subBrands = subBrandRepository.findById(subBrandId).get();

		brandProducts.setSubBrands(subBrands);

		brandProductsRepo.save(brandProducts);

	}

	public List<BrandProducts> getAllBrandProducts() {
		return brandProductsRepo.findAll();

	}

	public void deleteBrandProductsById(Long id) {

		brandProductsRepo.deleteById(id);
	}

	public void updateBrandProducts(BrandProducts brandProducts) {

		Long bankProductId = brandProducts.getProductId();

		BrandProducts products = brandProductsRepo.findById(bankProductId).get();

		brandProducts.setProductCreatedBy(products.getProductCreatedBy());
		brandProducts.setProductName(products.getProductName());
		brandProducts.setProductPrice(products.getProductPrice());
		brandProducts.setProductModifiedBy(products.getProductModifiedBy());

		brandProductsRepo.save(brandProducts);
	}

}
