<%@page import="test.users.dto.UsersDto"%>
<%@page import="test.users.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//1.session scope 에서 로그인 된 아이디 불러오기
    	String id=(String)session.getAttribute("id");
    	//2.DB에서 가입된 정보를 불러온다. 
    	UsersDto dto=UsersDao.getInstance().getData(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>users/private/info.jsp</title>
</head>
<body>
	<div class="container">
		<h1>가입정보 입니다.</h1>
		<table>
			<tr>
				<th>아이디</th>
				<td><%=dto.getId() %></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><a href="pwd_updateform.jsp">수정하기</a></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=dto.getEmail() %></td>
			</tr>
			<tr>
				<th>가입일</th>
				<td><%=dto.getRegdate() %></td>
			</tr>
		</table>
		<a href="updateform.jsp">개인정보수정</a>
		<a href="javascript:deleteConfirm()">탈퇴</a> 
		<%--자바스크립트 링크로 넘어가게 누르면 delete.jsp로 들어간다 확인 누르면 true 아니면 false 값을 가지고 
			같이 넘어간다.
		--%>
	</div>
<script> 
	function deleteConfirm(){
		let isDelete=confirm("확인을 누르면 회원 탈퇴가 됩니다. 탈퇴 하시겠습니까?");
		is(isDelete){
			location.herf="delete.jsp";
		}
	}
</script>
</body>
</html>