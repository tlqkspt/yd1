<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><jsp:include page="topmenu.jsp"></jsp:include></div>
	<div>
		<p>
	</div>
	<div align="center">
	<h3>정보수정</h3>
	<form name="memberin" id="memberin" action="MemberUpdate.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="hidden" name="id" id="id" value=${dto.id }>${dto.id }</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="password" id="password"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" id="addr"></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" id="birth"></td>
			</tr>
		</table>
		<input type="submit" value="가입">
	</form>
	</div>
</body>
</html>