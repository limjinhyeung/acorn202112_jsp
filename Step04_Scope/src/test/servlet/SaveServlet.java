package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test/save")
public class SaveServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String nick=req.getParameter("nick");
		//여기는 세션이 없다. jsp에는 있는데 지역변수로
		//req. 해보면 getSession이 있다. 그걸 이용하면 jsp에 있는 지역변수session을 이용할수있다. 
		HttpSession session=req.getSession();
		session.setAttribute("nick", nick);
		/*
		 * Servlet에서는 HttpSession 객체가 기본객체로 제공되지않기 때문에
		 * HttpSession 객체가 필요하다면 HttpServletRequest 객체의 .getSesion()
		 * 메소드를 이용해서 HttpSession 객체의 참조값을 얻을수있다. 
		 */
		//응답
		PrintWriter pw=resp.getWriter();
		pw.println("nick save!!");
		pw.close();
	}
}
