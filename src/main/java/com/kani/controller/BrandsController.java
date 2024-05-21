package com.kani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kani.model.Brands;
import com.kani.service.BrandsService;

@RestController
public class BrandsController {

    @Autowired
    private BrandsService service;

    @PostMapping("/registerBrand")
    public ResponseEntity<String> saveBrand(@RequestBody Brands brand) {
        try {
            service.registerBrand(brand);
            return new ResponseEntity<>("Brand registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllBrands")
    public ResponseEntity<List<Brands>> getAllBrands() {
        try {
            List<Brands> brandsList = service.getAllBrands();
            return new ResponseEntity<>(brandsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateBrand")
    public ResponseEntity<String> updateBrand(@RequestBody Brands brand) {
        try {
            service.updateBrand(brand);
            return new ResponseEntity<>("Brand updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Brand not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteBrandById/{id}")
    public ResponseEntity<String> deleteBrandById(@PathVariable Integer id) {
        try {
            service.deleteBrandById(id);
            return new ResponseEntity<>("Brand deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete brand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
