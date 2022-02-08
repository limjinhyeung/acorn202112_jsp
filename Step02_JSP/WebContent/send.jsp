<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 안깨지도록 하려면
	request.setCharacterEncoding("utf-8");
	//폼 전송되는 파라미터 추출
	String msg=request.getParameter("msg");
	System.out.println(msg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>send.jsp</title>
</head>
<body>
	<p>클라이언트야 메세지 잘 받았음!</p>
</body>
</html>