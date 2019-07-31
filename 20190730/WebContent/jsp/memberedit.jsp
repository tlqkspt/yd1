<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<h3>회원 정보 수정</h3><p>
		<form id="frm" name="frm" action="MemberUpdate" method="post">
			<table border="1">
				<tr>
					<th align="center">성&nbsp;&nbsp;&nbsp;명</th>
					<td><input type="text" name="name" value="${dto.memberName }"></td>
				</tr>
				<tr>
					<th align="center">아이디</th>
					<td><input type="text" name="id" value="${dto.memberId }" readonly></td>
				</tr>
				<tr>
					<th align="center">비밀번호</th>
					<td><input type="password" name="password" value="${dto.memberPassword }"></td>
				</tr>
				<tr>
					<th align="center">생년월일</th>
					<td><input type="date" name="birth" value="${dto.memberBirth }"></td>
				</tr>
				<tr>
					<th align="center">주 소</th>
					<td><input type="text" name="addr" size="50" value="${dto.memberAddr}"></td>
				</tr>
			</table>
			<p>
				&nbsp;&nbsp;&nbsp;<input type="submit" value="회원수정">&nbsp;&nbsp;&nbsp;&nbsp; <!-- button 말고 submit하면 입력됨 왜 버튼안안됨? -->
				<input type="reset" value="취소">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" id="in" value="홈으로" onclick="location.href='index.html'"></p>
		</form>
	</div>
</body>
</html>