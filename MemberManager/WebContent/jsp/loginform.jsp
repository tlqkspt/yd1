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
	<div><jsp:include page="menu.jsp"></jsp:include></div>
	<div></div>
	<c:if test = "${sid==null }">
	<div align="center">
		<h3>로그인</h3>
		<form id="frm" name="frm" action="Login.do" method="post">
			<table>
				<tr>
					<td>사용자 ID</td>
					<td><input type="text" id="id" name="id"></td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" id="pw" name="pw"></td>
				</tr>
			</table>
			<input type="submit" value="로그인"> 
			<input type="reset" value="취소">
		</form>
	</div>
	</c:if>
	<c:if test = "${sid != null }">
		<div align = "center"><h3>${sname } 이미 로그인됨</h3></div>
	</c:if>
</body>
</html>