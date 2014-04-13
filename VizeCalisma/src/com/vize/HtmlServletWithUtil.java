package com.vize;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/htmlservletwithutil")
public class HtmlServletWithUtil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = "Yardimci Sinif Kullanimi";
		response.getWriter().println(
				ServletUtilies.HeadWithTitle(title) +		//Yardımcı servlet'in method'u çağırıldı
				
				"<body bgcolor=\"#fdf5e6\">\n" +
				"<h1>" + title + "</h1>\n" +
				"<p>Simple servlet for testing.</p>\n" +
				"</body></html>"
				
				);
	}

}
