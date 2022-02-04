package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fortune")
public class FortuneServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//오늘의 운세 목록.
		List<String> list = new ArrayList<>();
		list.add("동쪽으로 가면 귀인을 만나요");
		list.add("로또를 사면 3등이 당첨될거에요");
		list.add("이상형을 만날거에요");
		list.add("뜻밖의 횡제를 해요");
		list.add("물건을 잃어버릴지도 몰라요 조심해요");
		
		Random a = new Random();
		int b = a.nextInt(5);
		String c=list.get(b);
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
		pw.println("<p>오늘의 운세:  "+c+"</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
