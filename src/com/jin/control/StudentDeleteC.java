package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Student;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class StudentDeleteC
 */
@WebServlet("/StudentDeleteC")
public class StudentDeleteC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteC() {
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
		String snum = (String)request.getAttribute("snum");
		String name = (String)request.getAttribute("name");
		String major = (String)request.getAttribute("major");
		String hobby = (String)request.getAttribute("hobby");
		Student student = new Student(snum, name, major, hobby);		
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.deleteStudent(student)  > 0) {
			url="/SuccessDeletedV.jsp";
		} else {
			url="/FailDeletedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
