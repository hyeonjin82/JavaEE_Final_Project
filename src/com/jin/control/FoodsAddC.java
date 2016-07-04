package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Food;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class FoodsAddC
 */
@WebServlet("/FoodsAddC")
public class FoodsAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodsAddC() {
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
		String cuisine = (String)request.getAttribute("cuisine");
		String type = (String)request.getAttribute("type");
		Food food = new Food();
		food.setName(name);
		food.setCuisine(cuisine);
		food.setType(type);
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.addFood(food)) {
			url="/SuccessAddedV.jsp";
		} else {
			url="/FailAddedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
