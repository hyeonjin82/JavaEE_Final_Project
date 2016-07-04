package com.jin.control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManagerC
 */
@WebServlet("/ManagerC")
public class ManagerC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerC() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String name = request.getParameter("name");
		String table = request.getParameter("table");
		String url="/page00.jsp";
		if (action==null){
			action="start";
		}
		if (action.equals("start")){
			url="/page00.jsp";
			this.getServletContext().getRequestDispatcher(url).forward(request, response);
		} else if(action.equals("add")){
			if(request.getParameter("refresh") != null) {
				if (name.equalsIgnoreCase("Student")) {
					url="/SelectStudentC";
				} else if (name.equalsIgnoreCase("Food")){
					url="/SelectFoodC";
				} else if (name.equalsIgnoreCase("FoodService")){
					url="/SelectFoodServiceC";
				} else if (name.equalsIgnoreCase("Branch")){
					url="/SelectBranchC";
				} else if (name.equalsIgnoreCase("Frequents")){
					url="/SelectFrequentsC";
				} else if (name.equalsIgnoreCase("Provides")){
					url="/SelectProvidesC";
				} else if (name.equalsIgnoreCase("Likes")){
					url="/SelectLikeC";
				} else if (name.equalsIgnoreCase("Soup")){
					url="/SelectSoupC";
				} else if (name.equalsIgnoreCase("Sandwich")){
					url="/SelectSandwichC";
				} else if (name.equalsIgnoreCase("Salad")){
					url="/SelectSaladC";
				} 
				HttpSession session = request.getSession();
				session.setAttribute("tableName", name);
				response.addCookie(new Cookie("tableName", name));
//				request.setAttribute("table", name);
				this.getServletContext().getRequestDispatcher(url).forward(request, response);
			} else if (request.getParameter("sort") != null) {
				String order = request.getParameter("order");
				request.setAttribute("table", name);
				request.setAttribute("order", order);
				url="/SortTableC";
				this.getServletContext().getRequestDispatcher(url).forward(request, response);
			} else if (request.getParameter("clear") != null) {
				url="pagescontrol.jsp?command=page01";
				response.sendRedirect(url);
			}
		} else if (action.equals("update")){
			if (table.equalsIgnoreCase("frequents")){
				request.setAttribute("id", request.getParameter("id"));
				request.setAttribute("branchname", request.getParameter("branchname"));
				if(request.getParameter("addButton") != null) {	
					url="/FrequentsAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/FrequentsDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("student")){
				request.setAttribute("snum", request.getParameter("snum"));
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("major", request.getParameter("major"));
				request.setAttribute("hobby", request.getParameter("hobby"));
				if(request.getParameter("addButton") != null) {	
					url="/StudentAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("updateButton") != null) {
					url="/StudentUpdateC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/StudentDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("foodservice")){
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("category", request.getParameter("category"));
				request.setAttribute("rate", request.getParameter("rate"));
				if(request.getParameter("addButton") != null) {	
					url="/FoodServiceAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("updateButton") != null) {
					url="/FoodServiceUpdateC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/FoodServiceDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("branch")){
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("bnum", request.getParameter("bnum"));
				request.setAttribute("location", request.getParameter("location"));
				request.setAttribute("since", request.getParameter("since"));
				if(request.getParameter("addButton") != null) {	
					url="/BranchsAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("updateButton") != null) {
					url="/BranchsUpdateC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/BranchsDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("food")){
				request.setAttribute("name", request.getParameter("name"));
				request.setAttribute("cuisine", request.getParameter("cuisine"));
				request.setAttribute("type", request.getParameter("type"));
				if(request.getParameter("addButton") != null) {	
					url="/FoodsAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("updateButton") != null) {
					url="/FoodsUpdateC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/FoodsDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("provide")){
				request.setAttribute("foodService", request.getParameter("foodService"));
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("price", request.getParameter("price"));
				if(request.getParameter("addButton") != null) {	
					url="/ProvidesAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("updateButton") != null) {
					url="/ProvidesUpdateC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/ProvidesDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			} else if (table.equalsIgnoreCase("like")){
				request.setAttribute("student", request.getParameter("student"));
				request.setAttribute("food", request.getParameter("food"));
				if(request.getParameter("addButton") != null) {	
					url="/LikesAddC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} else if (request.getParameter("deleteButton") != null) {
					url="/LikesDeleteC";
					this.getServletContext().getRequestDispatcher(url).forward(request, response);
				} 
			}  
			
		} else if (action.equals("create")) {
			int count = Integer.parseInt(request.getParameter("count"));
			String tableName = request.getParameter("tableName");
			System.out.println("tableName"+tableName);
			for(int i=1;i<=count;i++) {
				request.setAttribute("cname"+i,request.getParameter("cname"+i));
				request.setAttribute("type"+i,request.getParameter("type"+i));
				request.setAttribute("size"+i,request.getParameter("size"+i));
			}
			request.setAttribute("count",count);
			request.setAttribute("tableName",tableName);
			url="/CreateTableC";
			this.getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}

}
