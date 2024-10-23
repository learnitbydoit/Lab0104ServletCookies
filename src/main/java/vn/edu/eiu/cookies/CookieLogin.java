package vn.edu.eiu.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class CookieLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();

		writer.println("<h3>Đăng nhập</h3>");
		writer.println("<form action='/Lab0104ServletCookies/login' method='post'>");
		writer.println("Username: <input type='text' name='username'>");
		writer.println("Password: <input type='password' name='password'>");
		writer.println("<input type='submit' value='login'>");
		writer.println("</form>");
		
		writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String userName = req.getParameter("username");
		String passwd = req.getParameter("password");

		//Kiểm tra đúng thông tin đăng nhập thì chuyển sang trang chào
		if(userName.equals("Thao") && passwd.equals("123456")){
			//Tạo cookie username có thời gian là 30s
			Cookie cookie1 = new Cookie("username", userName);
			cookie1.setMaxAge(10);
			
			//Chuyển về client
			resp.addCookie(cookie1);
			
			resp.sendRedirect("/Lab0104ServletCookies/welcome");
		}
		else {
			resp.sendRedirect("/Lab0104ServletCookies/login");
		}
		
		PrintWriter writer = resp.getWriter();
	}
}
