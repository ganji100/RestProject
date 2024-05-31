package com.kani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kani.entity.ClassicalMedicines;
import com.kani.request.ClassicalMedicinesRequest;
import com.kani.response.ClassicalMedicinesResponse;
import com.kani.service.ClassicalMedicinesService;


@RestController
@RequestMapping("/classicalmedicine")
public class ClassicalMedicinesController {
	@Autowired
	ClassicalMedicinesService service;
	
	@PostMapping("/addMedicine")
	public ResponseEntity<ClassicalMedicinesResponse> saveMedicine(@RequestBody ClassicalMedicinesRequest request) throws Exception{
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		response=service.addMedician(request);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	@GetMapping("/fetchMedicine")
	public ResponseEntity<ClassicalMedicinesResponse>getAllmedicinesr(){
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		response=service.getAllMedicine();
		return new ResponseEntity<>(response,HttpStatus.OK);

		
	}
	
	
	@PutMapping("/updateMedicine")
	public ResponseEntity<ClassicalMedicinesResponse>updateMedicine(@RequestBody  ClassicalMedicines cm){
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		response=service.updateMedicine(cm);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@DeleteMapping("/deleteMedicine/{id}")
	public ResponseEntity<ClassicalMedicinesResponse>deleteMedicine(@PathVariable int id){
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		response=service.deleteMedicine(id);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}