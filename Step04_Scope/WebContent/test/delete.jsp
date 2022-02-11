<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/delete.jsp</title>
</head>
<body>
<%
//세션을 지우는 코드 흔히 로그아웃으로 생각하면 된다. 
	session.removeAttribute("nick"); //name으로 불러온 세션 하나를 지운다. 
	session.invalidate();//세션 초기화(모든내용 삭제))
%>
	<p>session 영역에 저장된 값을 삭제 했습니다. </p>
	<a href="../index.jsp">인덱스로 돌아가기</a>
</body>
</html>