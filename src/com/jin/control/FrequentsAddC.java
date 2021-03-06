package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Frequent;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class FrequentsAddC
 */
@WebServlet("/FrequentsAddC")
public class FrequentsAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrequentsAddC() {
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
		String id = (String)request.getAttribute("id");
		String branchname = (String)request.getAttribute("branchname");
		Frequent frequent = new Frequent(id, branchname, 1);		
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.addFrequent(frequent)) {
			url="/SuccessAddedV.jsp";
		} else {
			url="/FailAddedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
