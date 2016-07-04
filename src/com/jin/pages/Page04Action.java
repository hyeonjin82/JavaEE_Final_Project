package com.jin.pages;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Page04Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response, Map<String, String> maps) {
		ActionForward forward = new ActionForward();
		forward.setUrl(maps.get("page04"));
		forward.setRedirect(true);
		return forward;
	}
}
