package vn.edu.eiu.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cookie-response"})
public class CookiesResponseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		writer.println("Xin chào! Tôi là Cookies! Tôi đã gửi các cookies cho bạn!");
		writer.println(new Date());
		
		//Tạo và gán giá trị cho cookie
		Cookie cookie1 = new Cookie("ID", "CSE456");
		
		//Thiết lập thời gian tồn tại là 5s
		cookie1.setMaxAge(10);
		
		//trả về cho client
		resp.addCookie(cookie1);
		
		//Tương tự cho cookie2
		Cookie cookie2 = new Cookie("Course-Name", "Advanced-Java-Programming");
		cookie2.setMaxAge(15);
		resp.addCookie(cookie2);
		
	}

}
