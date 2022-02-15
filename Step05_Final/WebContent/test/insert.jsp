<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title=request.getParameter("title");
	String content=request.getParameter("content");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/insert.jsp</title>
</head>
<body>
	<p><%=title %></p>
	<div><%=content %></div>
</body>
</html>