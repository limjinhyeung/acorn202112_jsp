<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼 전송되는 파라미터 추출하기 
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String email=request.getParameter("email");
	//dto에 담기
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setEmail(email);
	//db에 저장하기
	boolean isSuccess=UsersDao.getInstance().insert(dto);
	//가입결과 응답하기 
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/signup.jsp</title>
</head>
<body>
	<h1>알림</h1>
	<%if(isSuccess){ %>
		<p>
			<strong><%=id %></strong>님이 가입되었습니다.
			<a href="loginform.jsp">로그인하러가기</a>
		</p>
	<%}else{ %>
		<p>
			가입이 실패했습니다.
			<a href="signup_form.jsp">다시 가입하러 가기</a>
		</p>
	<%} %>
</body>
</html>