package com.vize;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formgetall")
public class FormGetAllParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Bütün parametreler alındı
		Enumeration <String> paramNames = request.getParameterNames();
		
		// Parametre isim ve değerlerinin ekrana yaz
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();					// parametre ismini al
			String[] paramValue = request.getParameterValues(paramName);	// parametrenin değerini al
			response.getWriter().println(paramName + ": " + paramValue);
		}
		
	}

}
