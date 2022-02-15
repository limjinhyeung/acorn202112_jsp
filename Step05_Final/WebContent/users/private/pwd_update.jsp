<%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session scope 에서 수정할 회원의 아이디를 읽어온다.
	String id=(String)session.getAttribute("id");
	//폼 전송되는 구 비밀번호, 새 비밀번호 읽어오기
	String pwd=request.getParameter("pwd");
	String newPwd=request.getParameter("newPwd");
	
	//DB에 수정반영하고 성공여부를 리턴받는다.
	UsersDto dto= new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setNewPwd(newPwd);
	
	boolean isSuccess=UsersDao.getInstance().updatePwd(dto);
	
	/*
		위의 정보를 이용해서 DB를 업데이트하는 UsersDao에 메소드를 만들어 보세요.
		메소드명은 updatePwd()
		
		작업 성공 여부를 리턴받아서 성공이면 로그아웃처리를 하고 다시 로그인하는 링크를 출력하고 
		실패이면 비밀번호가 일치하지 않는다는 메세지를 띄우고 다시 비밀번호 수정폼으로 이동할수 있도록 해보세요.
	*/
	
	//응답한다. 
%>
<!DOCTYPE html>
<html>
<head>
임)<meta charset="UTF-8">
<title>users/private/pwd_update.jsp</title>
</head>
<body>
	<div class="container">
		<%if(isSuccess){ %>
			<%session.removeAttribute("id"); %>
			<script>
				alert("수정 성공!");
				location.href="${pageContext.request.contextPath }/users/loginform.jsp";
			</script>
			
			
		<%} else{%>
			<script>
				alert("수정 실패!");
				location.href="${pageContext.request.contextPath }/users/pwd_updateform.jsp";
			</script>
		<%} %>
	</div>
</body>
</html>