package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.model.Brands;
import com.kani.repo.BrandsRepository;

@Service
public class BrandsService {

	
	@Autowired
	BrandsRepository brandsRepo;

	public void registerBrand(Brands b) {
	
				
		
		brandsRepo.save(b);
	}

	public List<Brands> getAllBrands() {
		return brandsRepo.findAll();
	}

	public Brands updateBrand(Brands b) {
		Long brandId = b.getBrandId();
		Brands brand = brandsRepo.findById(brandId).get();

		brand.setBrandName(b.getBrandName());
		brand.setBrandCreatedBy(b.getBrandCreatedBy());
		brand.setBrandUpdatedBy(b.getBrandUpdatedBy());

		return brandsRepo.save(brand);
	}

	

	public void deleteBrandById(long id) {
		brandsRepo.deleteById(id);
		
	}

	
}
