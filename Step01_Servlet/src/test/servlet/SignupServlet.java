package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/signup")
public class SignupServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("email");
		String gen=req.getParameter("gender");
		String[] hobby=req.getParameterValues("hobby");
		String job=req.getParameter("job");
		String lunch=req.getParameter("lunch");
		String comm=req.getParameter("comment");
		
		//id
		System.out.println("아이디 : "+id);
		//gender
		if(gen.equals("man")) {
			System.out.println("성별은 남자입니다.");
		}else {
			System.out.println("성별은 여자입니다.");
		}
		//hobby
		System.out.print("취미는 : ");
		for(String tmp:hobby) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		//job
		System.out.println("직업은 : "+ job);
		//lunch
		System.out.println("점심메뉴 : "+ lunch);
		//comment
		System.out.println("comment : " + comm);
		
		resp.setCharacterEncoding("utf-8");

		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>회원가입 양식</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<p>회원가입이 완료되었습니다.</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
