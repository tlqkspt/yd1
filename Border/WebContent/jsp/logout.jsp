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
	<div><jsp:include page="topmenu.jsp"></jsp:include></div>
	<div align="center">
		<div>
		<p>
		</div>
		<c:if test="${sid == null }">
			${name }로그인부터 하십쇼
		</c:if>
		<c:if test = "${sid != null}">
			${name }님 잘가요
			<%session.invalidate(); %>
			<%//session.removeAttribute("name");%>
			<%//session.removeAttribute("sid"); %>
		</c:if>
	</div>
</body>
</html>