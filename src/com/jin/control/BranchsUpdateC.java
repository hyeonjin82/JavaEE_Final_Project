package com.jin.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.beans.Branch;
import com.jin.dao.DataAccess;

/**
 * Servlet implementation class FrequentsAddC
 */
@WebServlet("/BranchsUpdateC")
public class BranchsUpdateC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchsUpdateC() {
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
		String bnum = (String)request.getAttribute("bnum");
		String location = (String)request.getAttribute("location");
		String since = (String)request.getAttribute("since");
		Branch branch = new Branch(name, bnum, location, since);		
		DataAccess ac = new DataAccess();
		String url = "";
		if (ac.updateBranch(branch)) {
			url="/SuccessUpdatedV.jsp";
		} else {
			url="/FailUpdatedV.jsp";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
