package com.jin.beans;

import java.io.Serializable;

public class Branch implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	String bnum;
	String location;
	String since;
	
	public Branch() {
		
	}

	public Branch(String name, String bnum, String location, String since) {
		super();
		this.name = name;
		this.bnum = bnum;
		this.location = location;
		this.since = since;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSince() {
		return since;
	}

	public void setSince(String since) {
		this.since = since;
	}

	@Override
	public String toString() {
		return "Branch [name=" + name + ", bnum=" + bnum + ", location=" + location + ", since=" + since + "]";
	}
	
}
