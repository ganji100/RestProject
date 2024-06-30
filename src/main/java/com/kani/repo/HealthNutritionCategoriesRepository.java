package com.kani.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.HealthNutrutionCategories;

@Repository
public interface HealthNutritionCategoriesRepository extends JpaRepository<HealthNutrutionCategories, Long>{

	 List<HealthNutrutionCategories> findByCategoryName(String categoryName);

}
