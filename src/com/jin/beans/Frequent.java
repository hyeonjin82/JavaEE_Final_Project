package com.jin.beans;

import java.io.Serializable;

public class Frequent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String student;
	String name;
	int bnum;
	
	public Frequent(String student, String name, int bnum) {
		super();
		this.student = student;
		this.name = name;
		this.bnum = bnum;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	@Override
	public String toString() {
		return "Frequent [student=" + student + ", name=" + name + ", bnum="
				+ bnum + "]";
	}
	
}
