
package com.kani.response;
import java.util.List;

import com.kani.entity.ClassicalMedicinesProducts;

public class ClassicalMedicinesProductResponse {
	List<ClassicalMedicinesProducts> allProducts;
	private String Status;
	private String Message;
	public List<ClassicalMedicinesProducts> getAllProducts() {
		return allProducts;
	}
	public void setAllProducts(List<ClassicalMedicinesProducts> allProducts) {
		this.allProducts = allProducts;
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
