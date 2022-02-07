package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/send")
public class SendServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * <input type="text" name="msg" placeholder="서버에 할말 입력" />
		 * 위에  input 요소의 입력한
		 * msg 라는 이름으로 전송된 문자열 추출하기
		 * */
		
		req.setCharacterEncoding("utf-8");
		
		String a=req.getParameter("msg");
		
		resp.setCharacterEncoding("utf-8");

		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title></title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>"+a+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
		
	}

}
