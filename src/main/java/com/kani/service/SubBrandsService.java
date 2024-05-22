package com.kani.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.Brands;
import com.kani.entity.SubBrands;
import com.kani.repo.BrandsRepository;
import com.kani.repo.SubBrandsRepository;

@Service
public class SubBrandsService {

    @Autowired
    private SubBrandsRepository subBrandsRepo;
    
    @Autowired
    private BrandsRepository brandsRepo;

    public void registerSubBrand(SubBrands subBrand) {
        Long brandId = subBrand.getBrands().getBrandId();
        Brands brand = brandsRepo.findById(brandId).get();
                
        subBrand.setBrands(brand);
        subBrandsRepo.save(subBrand);
    }

    public List<SubBrands> getAllSubBrands() {
        return subBrandsRepo.findAll();
    }

    public SubBrands updateSubBrand(SubBrands subBrands) {
		Long subBrandId = subBrands.getSubBrandId();
		SubBrands brand = subBrandsRepo.findById(subBrandId).get();

		brand.setSubBrandName(subBrands.getSubBrandName());
		brand.setSubBrandCreatedBy(subBrands.getSubBrandCreatedBy());
		brand.setSubBrandUpdatedBy(subBrands.getSubBrandUpdatedBy());

		return subBrandsRepo.save(brand);
	}

    public void deleteSubBrandById(Long id) {
        subBrandsRepo.deleteById(id);
    }
}
