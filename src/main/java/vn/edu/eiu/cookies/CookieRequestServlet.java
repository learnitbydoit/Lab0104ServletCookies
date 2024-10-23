package vn.edu.eiu.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cookie-request"})
public class CookieRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		//Yêu cầu tất cả các cookies từ server
		Cookie[] cookies = req.getCookies();
		
		//Xuất ra tất cả các cookies lấy được
		if(cookies != null) { 
			for(Cookie c : cookies) { 
				writer.println("A: ");
				writer.println(c.getName() + ":" + c.getValue() + "</br");
			}
		}
		else {
			writer.println("Không còn cookie nào!");
		}
	}

}
