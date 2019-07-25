<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String id;
	String pw;
%>

<%
	
	response.getCharacterEncoding();
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>

사용자 ID : <%= id %> <p>
패스워드 : <%= pw %>
</body>
</html>