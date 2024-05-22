

package com.kani.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kani.entity.ClassicalMedicines;
import com.kani.repo.ClassicalMedicinesRepository;
import com.kani.request.ClassicalMedicinesRequest;
import com.kani.response.ClassicalMedicinesResponse;





@Service
public class ClassicalMedicinesService {
	@Autowired
	ClassicalMedicinesRepository repo;
	
	public ClassicalMedicinesResponse addMedician(ClassicalMedicinesRequest req) {
		ClassicalMedicinesResponse res=new ClassicalMedicinesResponse();
		ClassicalMedicines cm= new ClassicalMedicines();
		cm.setName(req.getName());
		cm.setCreatedBy(req.getCreatedBy());
    cm.setUpdatedBy(req.getUpdatedBy());	
    cm.setCreatedDate(req.getCreatedDate());
cm.setUpdatedDate(req.getUpdatedDate());
		repo.save(cm);
		res.setMessage("Successfully add Medicine");
		res.setStatus("Successes");
		
		 return res;
	}
	
	
	public ClassicalMedicinesResponse updateMedicine(ClassicalMedicines m) {
		ClassicalMedicinesResponse res=new ClassicalMedicinesResponse();
		int cmid=m.getCmId();
		ClassicalMedicines cmds=repo.findById(cmid);
		cmds.setName(m.getName());
		cmds.setUpdatedBy(m.getUpdatedBy());
		cmds.setCreatedBy(m.getCreatedBy());
      repo.save(cmds);
      res.setMessage("Medicine Updated");
      res.setStatus("Success");
      return res;
	}
	public ClassicalMedicinesResponse deleteMedicine(int id) {
		ClassicalMedicinesResponse res=new ClassicalMedicinesResponse();
			repo.deleteById(id);
			   res.setMessage("Medicine deleted");
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
			res.setMessage("fetching data");
			res.setStatus("Successfully");
		}
		return res;
	}
	
	

}