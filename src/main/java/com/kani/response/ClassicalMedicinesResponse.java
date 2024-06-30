
package com.kani.response;

import java.util.List;

import com.kani.entity.ClassicalMedicines;

public class ClassicalMedicinesResponse {
	List<ClassicalMedicines> allMedicines;
	private String Status;
	private String Message;

	public List<ClassicalMedicines> getAllMedicines() {
		return allMedicines;
	}

	public void setAllMedicines(List<ClassicalMedicines> allMedicines) {
		this.allMedicines = allMedicines;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

}
