
package com.kani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.ClassicalMedicines;
import com.kani.request.ClassicalMedicinesRequest;
import com.kani.response.ClassicalMedicinesResponse;
import com.kani.repo.ClassicalMedicinesRepository;





@Service
public class ClassicalMedicinesService {
	@Autowired
	ClassicalMedicinesRepository repo;
	
	public ClassicalMedicinesResponse addMedician(ClassicalMedicinesRequest request) {
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		ClassicalMedicines classicalMedicine= new ClassicalMedicines();
		classicalMedicine.setClassicalMedicineName(request.getClassicalMedicineName());
		classicalMedicine.setCreatedBy(request.getCreatedBy());
		classicalMedicine.setUpdatedBy(request.getUpdatedBy());	
		classicalMedicine.setCreatedDate(request.getCreatedDate());
		classicalMedicine.setUpdatedDate(request.getUpdatedDate());
		repo.save(classicalMedicine);
		response.setMessage("Successfully add Medicine");
		response.setStatus("Successes");
		
		 return response;
	}
	
	
	public ClassicalMedicinesResponse updateMedicine(ClassicalMedicines classicalMedicine) {
		ClassicalMedicinesResponse response=new ClassicalMedicinesResponse();
		int classicalMedicineId=classicalMedicine.getClassicalMedicineId();
		ClassicalMedicines existingMedicine=repo.findById(classicalMedicineId);
		existingMedicine.setClassicalMedicineName(classicalMedicine.getClassicalMedicineName());
		existingMedicine.setUpdatedBy(classicalMedicine.getUpdatedBy());
		existingMedicine.setCreatedBy(classicalMedicine.getCreatedBy());
      repo.save(existingMedicine);
      response.setMessage("Medicine  is Updated");
      response.setStatus("Success");
      return response;
	}
	public ClassicalMedicinesResponse deleteMedicine(int id) {
		ClassicalMedicinesResponse res=new ClassicalMedicinesResponse();
			repo.deleteById(id);
			   res.setMessage("Medicine is  deleted");
			      res.setStatus("Success");
			      return res;
			
	}
	public ClassicalMedicinesResponse  getAllMedicine(){
		ClassicalMedicinesResponse res = new ClassicalMedicinesResponse();
		List<ClassicalMedicines> list = new ArrayList<ClassicalMedicines>();
		List<ClassicalMedicines> db = repo.findAll();
		if (db.size() > 0) {
			for (ClassicalMedicines cm: db) {
				list.add(cm);
			}
			res.setAllMedicines(list);
			res.setMessage("fetching  the data from Database");
			res.setStatus("Successfully");
		}
		return res;
	}
	
	

}