package com.jin.beans;

import java.io.Serializable;

public class Like implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String student;
	String food;
	
	public Like() {
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Likes [student=" + student + ", food=" + food + "]";
	}
	

}
