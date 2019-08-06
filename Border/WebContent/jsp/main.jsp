<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<div align="center">
		<jsp:include page="topmenu.jsp"></jsp:include>
		<c:if test="${sid != null }">
			<div><p></div>
			<div>
				<h3> ${name}님의 My Page 환영.</h3>
			</div>
		</c:if>
		<c:if test="${sid == null }">
			<div><p></div>
			<div>
				<h3>모두의페이지.</h3>
			</div>
		</c:if>
	</div>
</body>
</html>