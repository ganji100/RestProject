package com.kani.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kani.entity.HealthNutritionProducts;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthNutritionProductsResponse {
	
	private HealthNutritionProducts products;
	private List<HealthNutritionProducts> ListProducts;
	private String message;
	private String status;

	public HealthNutritionProducts getProducts() {
		return products;
	}

	public void setProducts(HealthNutritionProducts products) {
		this.products = products;
	}

	public List<HealthNutritionProducts> getListProducts() {
		return ListProducts;
	}

	public void setListProducts(List<HealthNutritionProducts> listProducts) {
		ListProducts = listProducts;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String messsage) {
		this.message = messsage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
