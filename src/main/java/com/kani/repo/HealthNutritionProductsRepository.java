package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.HealthNutritionProducts;

@Repository
public interface HealthNutritionProductsRepository extends JpaRepository<HealthNutritionProducts, Long>{

}
