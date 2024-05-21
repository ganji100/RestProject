package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.model.SubBrands;

@Repository
public interface SubBrandsRepository extends JpaRepository<SubBrands,Long> {

}
