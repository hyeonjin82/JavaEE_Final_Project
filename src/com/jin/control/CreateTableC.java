package com.jin.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.dao.DataAccess;

/**
 * Servlet implementation class CreateTableC
 */
@WebServlet("/CreateTableC")
public class CreateTableC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTableC() {
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
		int count = (int)request.getAttribute("count");
		String tableName = (String)request.getAttribute("tableName");
		String[] colName = new String[count];
		String[] colType = new String[count];
		String[] colsize = new String[count];
		String col = "";
		for(int i=1;i<=count;i++) {
			colName[i-1] = (String) request.getAttribute("cname"+i);
			colType[i-1] = (String) request.getAttribute("type"+i);
			colsize[i-1] = (String) request.getAttribute("size"+i);
			col += colName[i-1]+" "+colType[i-1]+" ("+colsize[i-1]+")";
			if (i != count){
				col += ",";
			}
		}
		DataAccess ac = new DataAccess();
		System.out.println(col);
		ac.createTable(tableName,col);
		this.getServletContext().getRequestDispatcher("/page03.jsp").forward(request, response);
	}

}
