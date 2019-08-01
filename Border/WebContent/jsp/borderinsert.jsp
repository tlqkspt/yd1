<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
<div align="center">
	<div><jsp:include page="topmenu.jsp"></jsp:include></div>
	<div><p></div>
	<div><h3>글 쓰기</h3></div>
	<div><p></div>
	<div>
		<form id="frm" name="frm" action="BorderInsert.do" method="post">
			<div><table border="1">
				<tr>
					<td width="100" align="center">글 번 호</td>
					<td width="640"><input type="text" id="no" name="no"></td>
				</tr>
				<tr>
					<td align="center">작 성 자</td>
					<td><input type="text" id="writer" name="writer"></td>
				</tr>
				<tr>
					<td align="center">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
					<td><input type="text" id="subject" name="subject"></td>
				</tr>
				<tr>
					<td align="center">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
					<td><textarea id="contents" name="contents" rows="10" cols="100"></textarea></td>
				</tr>
				<tr>
					<td align="center">작성일자</td>
					<td><input type="date" id="date" name="date"></td>
				</tr>
				<tr>
					<td align="center">조 회 수</td>
					<td><input type="text" id="hit" name="hit"></td>
				</tr>
				</table>
			</div>
		</form>
	</div>
</div>
</body>
</html>