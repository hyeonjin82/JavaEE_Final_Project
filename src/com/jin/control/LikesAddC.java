package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Like;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class FoodsAddC
 */
@WebServlet("/LikesAddC")
public class LikesAddC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikesAddC() {
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
		String student = (String)request.getAttribute("student");
		String food = (String)request.getAttribute("food");
		Like like = new Like();
		like.setStudent(student);
		like.setFood(food); 
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.addLike(like)) {
			url="/SuccessAddedV.jsp";
		} else {
			url="/FailAddedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
