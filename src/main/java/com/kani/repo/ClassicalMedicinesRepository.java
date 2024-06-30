
package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.ClassicalMedicines;
@Repository
public interface ClassicalMedicinesRepository extends JpaRepository<ClassicalMedicines, Integer> {
	ClassicalMedicines findById(int cmId);

}
