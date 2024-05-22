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

import com.kani.model.Registration;
import com.kani.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	RegistrationService registerService;

	@PostMapping("/registerCustomer")
	public ResponseEntity<String> registerCustomer(@RequestBody Registration registration) {
		try {
			registerService.registerCustomer(registration);
			return new ResponseEntity<>("Customer registered sukklllllllllllllllllllllllllllllkccessfully", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to register Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Registration>> getAllCustomers() {
		try {
			List<Registration> getAllCustomersList = registerService.getAllCustomers();
			return new ResponseEntity<>(getAllCustomersList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestBody Registration registration) {
		try {
			registerService.updateCustomer(registration);
			return new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to update Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteCustomerById/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
		try {
			registerService.deleteCustomerById(id);
			System.out.println("hrllo");
			return new ResponseEntity<>("Customer deleted successfully", HttpStatus.OK);
		
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete Customer", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}
