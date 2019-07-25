<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 데이터전달 목적으로 하는 param 연습 -->

<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:forward page="result.jsp">
	<jsp:param name="id" value="홍길동a" />
	<jsp:param name="pw" value="1234" />
</jsp:forward>
</body>
</html>