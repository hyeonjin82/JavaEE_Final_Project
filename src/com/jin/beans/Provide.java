package com.jin.beans;

import java.io.Serializable;

public class Provide implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String foodService;
	String food;
	Double price;
	
	public Provide() {
	}
	
	public Provide(String foodService, String food, Double price) {
		this.foodService = foodService;
		this.food = food;
		this.price = price;
	}

	public String getFoodService() {
		return foodService;
	}
	public void setFoodService(String foodService) {
		this.foodService = foodService;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Provides [foodService=" + foodService + ", food=" + food
				+ ", price=" + price + "]";
	}
	
}
