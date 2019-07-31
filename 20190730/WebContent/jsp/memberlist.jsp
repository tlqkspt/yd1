<%@page import="java.util.ArrayList"%>
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
	<div align="center"><h3>회원목록 보기</h3>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>이 름</td>
				<td>주 소</td>
				<td>생년월일</td>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.memberId}</td>
					<td>${dto.memberName }</td>
					<td>${dto.memberAddr}</td>
					<td>${dto.memberBirth }</td>
				</tr>
			</c:forEach>
		</table>
		<p> &nbsp;&nbsp;
		<button type="button" onclick="location.href='./index.html'">홈으로</button>
	</div>
</body>
</html>