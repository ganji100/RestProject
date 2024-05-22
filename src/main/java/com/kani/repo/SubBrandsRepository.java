package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.SubBrands;

@Repository
public interface SubBrandsRepository extends JpaRepository<SubBrands,Long> {

}
