<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String nick=request.getParameter("nick");
	
	//HttpSession 객체에 "nick"이라는 키 값으로 입력한 nick 저장하기 session 은 웹을 닫거나 지우기전까지 저장한다 request는 1회성으로 응답하고 나면 사라지는데 반대개념이다. 
	session.setAttribute("nick", nick);
	//60초동안 어떤 요청도 하지않으면 자동으로 삭제되도록 설정(설정하지않으면 기본 30분)
	session.setMaxInactiveInterval(60); //시간설정코드
	//로그인처리할때 사용하는 코드이다. 로그인하면 세션에 담아두고 다른곳으로 이동해도 저장이 된다. 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test/save.jsp</title>
</head>
<body>
	<p><strong><%=nick %></strong>이라는 닉네임을 기억 하겠습니다.</p>
	<p>60초동안 아무런 요청을 하지않거나 웹브라우저를 닫으면 자동 삭제 됩니다. </p>
	<a href="../index.jsp">인덱스로 이동하기</a>
</body>
</html>