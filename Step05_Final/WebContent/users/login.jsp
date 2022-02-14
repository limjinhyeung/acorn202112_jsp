<%@page import="java.net.URLEncoder"%>
<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 후 가야할 목적지 정보
	String url=request.getParameter("url");
	//로그인 실패를 대비해서 목적지 정보를 인코딩한 결과도 준비한다.
	String encodeUrl=URLEncoder.encode(url);

	//폼 전송되는 아이디, 비밀번호 읽어오기
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//dto에 담기
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	// dao를 이용해서 DB에 존재하는지 맞는 정보인지 확인한다. 
	boolean isValid=UsersDao.getInstance().isValid(dto);
	if(isValid){
		//로그인처리(로그인된 아이디를 session scope에 저장)
		session.setAttribute("id", id);
	}
	//응답
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/login.jsp</title>
</head>
<body>
	<div class="container">
		<h1>알림</h1>
		<%if(isValid){ %>>
			<p>
				<strong><%=id %></strong>님이 로그인 되었습니다. 
				<a href="<%=url%>">확인</a>
			</p>
		<%}else{ %>
			<p>
				아이디 혹은 비밀번호가 틀려요
				<a href="${pageContext.request.contextPath }/users/loginform.jsp?url=<%=encodeUrl%>">다시시도</a>
			</p>
		<%} %>
	</div>
</body>
</html>