package com.vize;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/htmlservlet")
public class HtmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");	//Burasının bir html text sayfası olacağını browser a söyler
		response.getWriter().println(
				"<!DOCTYPE html>\n" +
						"<html>\n" +
						"<head><title>Servlet'e Gömülü Html Sayfası</title></head>\n" +
						"<body bgcolor=\"#fdf5e6\">\n" +
						"<h1>Test</h1>\n" +
						"<p>Simple servlet for testing.</p>\n" +
						"</body></html>"
				);
	}

}
