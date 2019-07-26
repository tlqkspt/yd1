<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action="deleteOK.jsp" method="post">
	<table border="1">
		<tr>
			<th><select name="select"><option value="id">아이디</option>
									  <option value="name">이름</option>
									  <option value="tel">전화번호</option></select>
									  </th>
			<td> <input type="text" name="inputValue"> </td>   
		</tr>
	</table><p>
	<input type="submit" value="등록">

</form>
</body>
</html>