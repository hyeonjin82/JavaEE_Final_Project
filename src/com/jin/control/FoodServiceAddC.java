package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.FoodService;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class FoodServiceAddC
 */
@WebServlet("/FoodServiceAddC")
public class FoodServiceAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServiceAddC() {
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
		String name = (String)request.getAttribute("name");
		String category = (String)request.getAttribute("category");
		int rate = Integer.parseInt((String)request.getAttribute("rate"));
		FoodService foodService = new FoodService(name, category, rate);		
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.addFoodService(foodService)) {
			url="/SuccessAddedV.jsp";
		} else {
			url="/FailAddedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
