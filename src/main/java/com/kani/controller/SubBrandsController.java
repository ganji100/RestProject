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

import com.kani.model.SubBrands;
import com.kani.service.SubBrandsService;

@RestController
public class SubBrandsController {

    @Autowired
    private SubBrandsService service;

    @PostMapping("/registerSubBrand")
    public ResponseEntity<String> saveSubBrand(@RequestBody SubBrands subBrand) {
        try {
            service.registerSubBrand(subBrand);
            return new ResponseEntity<>("SubBrand registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register SubBrand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllSubBrands")
    public ResponseEntity<List<SubBrands>> getAllSubBrands() {
        try {
            List<SubBrands> subBrandsList = service.getAllSubBrands();
            return new ResponseEntity<>(subBrandsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateSubBrand")
    public ResponseEntity<String> updateSubBrand(@RequestBody SubBrands subBrand) {
        try {
            service.updateSubBrand(subBrand);
            return new ResponseEntity<>("SubBrand updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("SubBrand not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update SubBrand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteSubBrandById/{id}")
    public ResponseEntity<String> deleteSubBrandById(@PathVariable Long id) {
        try {
            service.deleteSubBrandById(id);
            return new ResponseEntity<>("SubBrand deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete SubBrand", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
