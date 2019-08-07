<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div align="center">
		<jsp:include page="menu.jsp"></jsp:include>
		<c:if test="${sid != null }">
			<div><p></div>
			<div align="center">
				<h3> ${sname}님의 My Page 환영.</h3>
			</div>
			<div><img alt="나비" src="image/11.jpg" width="300" height="300"></div>
		</c:if>
		<c:if test="${sid == null }">
			<div><p></div>
			<div>
				<h3>모두의페이지.</h3>
			</div>
			<div><img alt="나비아님" src="image/11.jpg"  width="60%" height="60%"></div>
		</c:if>
	</div>
</body>
</html>