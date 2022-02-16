<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그인 판별 - session scope에 "id"라는 키값으로 저장된 문자열이 있는지 읽어와 본다.
	String id=(String)session.getAttribute("id");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<jsp:include page="/include/resource.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/include/navbar.jsp"></jsp:include>
	<div class="container">
		<%if(id!=null){ %>
			<p>
				<a href="users/private/info.jsp"><%=id %></a> 님, 로그인 중...
				<a href="users/logout.jsp">로그아웃</a>
			</p>
		<%}else{ %>
			<li><a href="users/loginform.jsp">로그인</a></li>
		<%} %>
		
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
			<li><a href="users/signup_form.jsp">회원가입</a></li>
			<li><a href="private/study.jsp">회원전용공간(공부)</a></li>
			<li><a href="private/game.jsp">회원전용공간(게임)</a></li>
		</ul>
	</div>
</body>
</html>