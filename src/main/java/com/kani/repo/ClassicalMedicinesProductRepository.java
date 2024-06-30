
package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.ClassicalMedicinesProducts;

@Repository
public interface ClassicalMedicinesProductRepository extends JpaRepository<ClassicalMedicinesProducts, Integer> {
	ClassicalMedicinesProducts findById(int id);
}
