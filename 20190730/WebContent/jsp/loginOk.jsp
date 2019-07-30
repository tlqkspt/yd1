<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String loginId;
	
	loginId = (String)request.getAttribute("loginId");
	
	if(loginId != null){ %>
		<h3><%=loginId %> 님 환영합니다</h3>
		<h3><a href="memberEdit">회원정보수정</a></h3>
		<h3><a href="memberList">회원목록보기</a></h3>   <!-- 서블릿하나 만들면됨 -->
		<h3><a href="./index.html">홈으로가기</a></h3>
	<%} else {%> 
		<h3>아이디 또는 비밀번호를 다시 확인하세요. </h3>
		<button type="button" onclick="location.href='html/login.html'">로그인화면</button>
		<button type="button" onclick="location.href='./index.html'">홈으로</button>
	<%} %>
</body>
</html>