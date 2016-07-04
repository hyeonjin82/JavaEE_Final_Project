package com.jin.beans;

import java.io.Serializable;

public class FoodService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	String category;
	int rate;
	
	public FoodService() {
		
	}

	public FoodService(String name, String category, int rate) {
		super();
		this.name = name;
		this.category = category;
		this.rate = rate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "FoodService [name=" + name + ", category=" + category + ", rate=" + rate + "]";
	}
	
}
