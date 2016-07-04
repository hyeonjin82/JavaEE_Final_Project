package com.jin.pages;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PageManagerC
 */
@WebServlet("/PageManagerC")
public class PageManagerC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PageManagerC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = new Command(request);
		Map<String, String> maps = new HashMap<String,String>();
		maps.put("page00", "./page00.jsp");
		maps.put("page01", "./page01.jsp");
		maps.put("page02", "./page02.jsp");
		maps.put("page021", "./page021.jsp");
		maps.put("page022", "./page022.jsp");
		maps.put("page023", "./page023.jsp");
		maps.put("page024", "./page024.jsp");
		maps.put("page025", "./page025.jsp");
		maps.put("page026", "./page026.jsp");
		maps.put("page027", "./page027.jsp");
		maps.put("page03", "./page03.jsp");
		maps.put("page04", "./page04.jsp");
		maps.put("thankyou", "./Thankyou.jsp");
		
		Action comm=null;
		if(command.getCommand().equalsIgnoreCase("page00")){
			comm=new Page00Action();
		} else if (command.getCommand().equalsIgnoreCase("page01")) {
			comm=new Page01Action();
		} else if (command.getCommand().equalsIgnoreCase("page02")) {
			comm=new Page02Action();
		} else if (command.getCommand().equalsIgnoreCase("frequents")) {
			comm=new Page021Action();
		} else if (command.getCommand().equalsIgnoreCase("student")) {
			comm=new Page022Action();
		} else if (command.getCommand().equalsIgnoreCase("foodservice")) {
			comm=new Page023Action();
		} else if (command.getCommand().equalsIgnoreCase("branch")) {
			comm=new Page024Action();
		} else if (command.getCommand().equalsIgnoreCase("food")) {
			comm=new Page025Action();
		} else if (command.getCommand().equalsIgnoreCase("provides")) {
			comm=new Page026Action();
		} else if (command.getCommand().equalsIgnoreCase("likes")) {
			comm=new Page027Action();
		} else if (command.getCommand().equalsIgnoreCase("page03")) {
			comm=new Page03Action();
		} else if (command.getCommand().equalsIgnoreCase("page04")) {
			comm=new Page04Action();
		} else if (command.getCommand().equalsIgnoreCase("thankyou")) {
			comm=new PageTnxAction();
		} else {
			comm=new Page02Action();
		}
		
		ActionForward forword = comm.execute(request, response, maps);
		forword.go(request, response);
	}

}
