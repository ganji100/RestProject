package com.kani.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kani.entity.Brands;

@Repository
public interface BrandsRepository extends JpaRepository<Brands,Long> {

}
