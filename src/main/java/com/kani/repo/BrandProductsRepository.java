package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.BrandProducts;

@Repository
public interface BrandProductsRepository extends JpaRepository<BrandProducts,Long> {

}
