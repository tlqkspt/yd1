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
	<div><jsp:include page="menu.jsp"></jsp:include></div>
	<c:forEach items="dto" var="s">
		
	</c:forEach>
	<div><br></div><c:if test="${sid != null }">
	<h3>${sname }님 환영</h3></c:if>
	<div>
		<c:if test="${ sid == null }">
			아이디 패스워드 일치x
			다시로그인
			<%	session.removeAttribute("name");
			 	session.removeAttribute("id");
			%>	<!-- 세션 삭제하기 -->
			<button type="button" onclick="location.href='LoginForm.do'">확인</button>
		</c:if>
	</div></div>
</body>
</html>