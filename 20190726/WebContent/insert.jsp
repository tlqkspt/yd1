<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>학생 추가 하기</h3><p>
<form name="frm" action="insertOK.jsp" method="post">
	<table border="1">
		<tr>
		 	<th>아이디</th>
		 	<td> <input type="text" name="id"></td>
		</tr>
		<tr>
			<th>성명</th>
			<td> <input type="text" name="name"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td> <input type="text" name="tel"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td width="100"><input type="text" name="addr" size="80"></td>
		</tr>
	</table><p>
	<input type="submit" value="등록"> &nbsp;&nbsp;&nbsp;
	<input type="reset" value="초기화">
</form>
</body>
</html>