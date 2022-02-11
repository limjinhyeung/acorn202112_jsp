package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fortune")
public class FortuneServlet extends	HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직을 수행했다고 가정하자
		String a="동쪽으로 가면 귀인을 만나요";
		
		//2. 로직의 수행결과 데이터(모델) 을 HttpServletRequest객체에 담는다
		req.setAttribute("fortuneToday", a);
		
		/*
		 * 요청 전달자 객체(RequestDispatcher)
		 * 
		 * HttpServletRequest 객체의 
		 * 
		 * .getRequestDispatcher("요청을 전달받을 Webcontent 안에 있는jsp 페이지의 위치")
		 * 
		 * 메소드를 이용해서 얻어낼수 있다. 
		 */
		
		RequestDispatcher rd=req.getRequestDispatcher("/test/fortune.jsp");
		
		//지정된 jsp페이지로 응답을 위임시킨다. 
		rd.forward(req, resp);
	}
}
