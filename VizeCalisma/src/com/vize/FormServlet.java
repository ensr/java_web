package com.vize;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;


@WebServlet("/formservlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * request.getParameter() ile index sayfasından girilen değerler alındı.
		 */
		
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		response.getWriter().println("isim: " + name + "\n" + "sifre: " + pass);
		
		//response.sendRedirect("formgetall"); 	//başka bir sevlet'e yönlendirme
		Cookie[] cookies = request.getCookies();
		
		Boolean newbie = true;
		
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("name") && cookie.getValue().equals("ensar")){
					newbie = false;
					break;
				}
			}
		}
		String title;
		if(newbie){
			Cookie rcookie = new Cookie("name", name);
			rcookie.setMaxAge(60*60*24*2);
			response.addCookie(rcookie);
			title = "Hosgeldiniz";
		} else {
			title = "Tekrar Hosgeldiniz";
		}
		
		response.getWriter().write(title);
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		/*Cookie cookie = new Cookie("cname", name);
		cookie.setMaxAge(60*60*24*2);
		response.addCookie(cookie);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/readcookie");  
        rd.forward(request, response);
		*/
	}

}
