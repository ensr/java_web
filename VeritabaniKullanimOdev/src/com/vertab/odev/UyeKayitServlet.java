package com.vertab.odev;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


@WebServlet("/uyekayit")
public class UyeKayitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String dogumtarihi = request.getParameter("dogumtarihi");
		String eposta = request.getParameter("eposta");
		String password = request.getParameter("password");
		String yetkiID = request.getParameter("yetkiID");
		
		
		
		
		try{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ogrencidb", "root", "271-");
			PreparedStatement ps= (PreparedStatement) ((java.sql.Connection) conn).prepareStatement(
					"insert into tuser(username,password,ad,soyad,dogumtarihi,epostaadresi,userphoto,yetkiID) values (?,?,?,?,?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3, ad);
			ps.setString(4,soyad);
			ps.setString(5, dogumtarihi);
			ps.setString(6, eposta);
			ps.setInt(7, 11);
			ps.setString(8, yetkiID);
			
			ps.execute();
			
			getServletContext().getRequestDispatcher("login.html").forward(request, response);
			
		}catch(Exception e){
			System.out.println(e);
			
		}
	}

}
