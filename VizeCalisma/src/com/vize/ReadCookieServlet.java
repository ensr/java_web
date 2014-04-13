package com.vize;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/readcookie")
public class ReadCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean newbie = false;
		String cookieName = "cname";
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookieName.equals(cookie.getName())){
					response.getWriter().write(cookie.getValue());
				}
			}
		}
	}

}
