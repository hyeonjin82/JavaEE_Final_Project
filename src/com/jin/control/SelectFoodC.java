package com.jin.control;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jin.dao.DataAccess;

/**
 * Servlet implementation class SelectFoodC
 */
@WebServlet("/SelectFoodC")
public class SelectFoodC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFoodC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String table = (String)request.getAttribute("table");
		HttpSession session = request.getSession();
		String table = (String) session.getAttribute("tableName");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies){
				if(cookie.getName().equals("tableName")){
//					String table1 = (String) cookie.getValue();
//					System.out.println(table1);
				}
			}
		}
		String order = "name";
		DataAccess ac = new DataAccess();
		List<Map<String,String>> lists = ac.selectTable(table, order);
		List<String> colNames = ac.getColunmNames(table);
		request.setAttribute("lists", lists);
		request.setAttribute("colNames", colNames);
		this.getServletContext().getRequestDispatcher("/pagescontrol.jsp?command=page01").forward(request, response);
	}

}
