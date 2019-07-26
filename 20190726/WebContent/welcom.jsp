<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 환영합니다. <%= session.getAttribute("id") %> </h1>
<%= session.getId() %> 세션 고유아이디 확인  <br>
<a href="userHome.jsp">세션유지 확인</a>
<a href="logout.jsp">로그아웃</a>
</body>
</html>