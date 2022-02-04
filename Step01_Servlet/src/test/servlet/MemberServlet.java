package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.dto.MemberDto;

@WebServlet("/member/list")
public class MemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//DB에서 불러온 있는 회원목록이라고 가정하자. 
		List<MemberDto> list = new ArrayList<MemberDto>();
		list.add(new MemberDto(1,"김구라","노량진"));
		list.add(new MemberDto(2,"해골","무덤"));
		list.add(new MemberDto(3,"원숭이","동물원"));
		
		resp.setCharacterEncoding("utf-8");

		resp.setContentType("text/html; charset=utf-8");

		PrintWriter pw = resp.getWriter();
		pw.println("<!doctype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset='utf-8'>");
		pw.println("<title>회원정보 목록</title>");
		pw.println("</head>");
		pw.println("<body>");
	      pw.println("<table>");
	         pw.println("<thead>");
	            pw.println("<tr>");
	               pw.println("<th>번호</th>");
	               pw.println("<th>이름</th>");
	               pw.println("<th>주소</th>");
	            pw.println("</tr>");
	         pw.println("</thead>");
	         pw.println("<tbody>");
	            //반복문 돌면서 회원 목록을 출력해 보세요
//	         	for(int i=0;i<list.size();i++) {
//	         		pw.println("<tr>");
//	         		pw.println("<td>"+list.get(i).getNum()+"</td>");
//	         		pw.println("<td>"+list.get(i).getName()+"</td>");
//	         		pw.println("<td>"+list.get(i).getAddr()+"</td>");
//	         		pw.println("</tr>");
//	         	}
	         	for(MemberDto tmp:list) {
	         		pw.println("<tr>");
	         		pw.println("<td>"+tmp.getNum()+"</td>");
	         		pw.println("<td>"+tmp.getName()+"</td>");
	         		pw.println("<td>"+tmp.getAddr()+"</td>");
	         		pw.println("</tr>");
	         	}
	         pw.println("</tbody>");
	      pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
