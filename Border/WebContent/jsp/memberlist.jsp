<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/f2.js"></script>
</head>
<body>
	<div><jsp:include page="topmenu.jsp"></jsp:include></div>
	<div>
		<p>
	</div>
	<div align="center">
		<h3>회원목록</h3>
		<form name="frm" id="frm" action="MemberUpdateForm.do" method="post">
					<input type="hidden" name="id">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>주소</td>
				<td>생년월일</td>
			</tr>
			<c:forEach items="${list }" var="dto">
				<tr align="center" onmouseover="this.style.background='#bbbbbb'" onmouseout="this.style.background='white'"
					onclick="formSubmit(${dto.id })">
					<td>${dto.id }</td>
					<td>${dto.pw }</td>
					<td>${dto.name }</td>
					<td>${dto.addr }</td>
					<td>${dto.birth }</td>
				</tr>
				<c:if test="${dto.id == null }">
				등록된 글이 없습니다.
			</c:if>
			</c:forEach>
		</table>
		</form>
	</div>
</body>
</html>