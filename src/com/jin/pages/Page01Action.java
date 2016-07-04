package com.jin.pages;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jin.dao.DataAccess;

public class Page01Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, Map<String, String> maps) {
		DataAccess ac = new DataAccess();
		List<String> lists = ac.selectTables();
		ActionForward forward = new ActionForward();
		if(lists!=null){
			request.setAttribute("tablelist", lists);
			forward.setUrl(maps.get("page01"));
			forward.setRedirect(false);
		}
		return forward;
	}
}
