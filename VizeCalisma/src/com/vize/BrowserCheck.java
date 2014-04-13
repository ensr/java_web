package com.vize;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/browsercheck")
public class BrowserCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userAgent = request.getHeader("User-Agent");
		if ((userAgent != null) && (userAgent.contains("MSIE"))) {
			response.sendRedirect("http://www.google.com");
		} else {
			response.sendRedirect("http://www.facebook.com");
		}
	}

}
