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

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

@WebServlet("/loginyonlendir")
public class LoginYonlendirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
	public static final String DB_URL="jdbc:mysql://localhost:3306/ogrencidb";
	public static final String USER = "root";
	public static final String PASS = "271-";
	    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = (Statement) conn.createStatement();
			
	        String sql = "SELECT * FROM tuser WHERE userName = '"+username+"'";
	        ResultSet rs = (ResultSet) stmt.executeQuery(sql);
	      
	        if (!rs.next()) {
        		PrintWriter pwd = response.getWriter();
		        pwd.write("Boyle bir kullanici bulunamadi");
        	    
        	}else {
        	   
		        String passdb = rs.getString("password");
		        int id = rs.getInt("yetkiID");
		        	
		        if (passdb.equals(password) && id == 0){
				    String destination = "/ogrenciekrani";  
		            RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);  
		            rd.forward(request, response);
				   
		        } else if (passdb.equals(password) && id == 1){
		        	String destination = "/hocaekrani";  
		            RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);  
		            rd.forward(request, response);
		        	
		        } else {
		        	PrintWriter pw5 = response.getWriter();
				    pw5.write("sifre yanlis");
		        }
		        
		    }   
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
