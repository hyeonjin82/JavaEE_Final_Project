package com.jin.pages;

import javax.servlet.http.HttpServletRequest;

public class Command {
	private String command;
	public Command(HttpServletRequest request) {
		command=request.getParameter("command");
		if(command==null) {
			command="";
		}
	}
	public String getCommand(){
		return command;
	}
}
