package com.jin.beans;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String snum;
	String name;
	String major;
	String hobby;
	
	public Student() {
		
	}
	public Student(String snum, String name, String major, String hobby) {
		super();
		this.snum = snum;
		this.name = name;
		this.major = major;
		this.hobby = hobby;
	}
	public String getSnum() {
		return snum;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Student [snum=" + snum + ", name=" + name + ", major=" + major + ", hobby=" + hobby + "]";
	}
	
}
