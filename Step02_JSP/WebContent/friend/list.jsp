<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
	List<String> list=new ArrayList<String>();
	list.add("김구라");
	list.add("해골");
	list.add("원숭이");
	list.add("주뎅이");
	list.add("덩어리");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>friend/list.jsp</title>
</head>
<body>
	<h1>친구목록 입니다.</h1>
	<ul>
		<%for(String tmp:list) { %>
			<li><%= tmp %></li>
		<%} %>
	</ul>
</body>
</html>