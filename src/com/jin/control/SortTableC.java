package com.jin.control;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.dao.DataAccess;

/**
 * Servlet implementation class SortTableC
 */
@WebServlet("/SortTableC")
public class SortTableC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortTableC() {
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
		String table = (String)request.getAttribute("table");
		String order = request.getParameter("order");
		DataAccess ac = new DataAccess();
		List<Map<String,String>> lists = ac.selectTable(table, order);
		List<String> colNames = ac.getColunmNames(table);
//		Collections.sort(lists, new Comparator<Map<String,String>>() {
//	        @Override
//	        public int compare(Map<String,String>  Provide1, Map<String,String>  Provide2){
//	        	if (order.equalsIgnoreCase("foodservice")){
//	        		return  Provide1.get("foodservice").compareTo(Provide2.get("foodservice"));
//	        	} else if (order.equalsIgnoreCase("food")) {
//	        		return  Provide1.get("food").compareTo(Provide2.get("food"));
//	        	} else {
//	        		return  Provide1.get("price").compareTo(Provide2.get("price"));
//	        	}
//	        }
//		});
		request.setAttribute("lists", lists);
		request.setAttribute("colNames", colNames);
		this.getServletContext().getRequestDispatcher("/pagescontrol.jsp?command=page01").forward(request, response);
	}
}
