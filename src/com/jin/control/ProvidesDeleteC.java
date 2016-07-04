package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Food;
import com.jin.beans.Provide;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class ProvidesDeleteC
 */
@WebServlet("/ProvidesDeleteC")
public class ProvidesDeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvidesDeleteC() {
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
		String foodService = (String)request.getAttribute("foodService");
		String food = (String)request.getAttribute("food");
		Provide provide = new Provide();	
		provide.setFoodService(foodService);
		provide.setFood(food);
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.deleteProvide(provide)  > 0) {
			url="/SuccessDeletedV.jsp";
		} else {
			url="/FailDeletedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
