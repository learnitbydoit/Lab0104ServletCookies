package vn.edu.eiu.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/welcome")
public class CookieWelcome extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		String name = "";
		
		Cookie[] cookies = req.getCookies();
		
		//Duyệt để lấy cookies
		if(cookies != null) {
			for(Cookie c : cookies)
				if(c.getName().equals("username")) // "username" là name của cookie
					name = c.getValue();
			writer.println("<h2>Xin chào " + name + "</h2>");
		}
		//Nếu chưa đăng nhập hoặc cookie hết time thì chuyển hướng sang trang login
		else
			resp.sendRedirect("/Lab0104ServletCookies/login");
	}
	
}
