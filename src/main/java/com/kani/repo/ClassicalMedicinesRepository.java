package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kani.entity.ClassicalMedicines;

public interface ClassicalMedicinesRepository extends JpaRepository<ClassicalMedicines, Integer> {
	ClassicalMedicines findById(int cmId);

}
