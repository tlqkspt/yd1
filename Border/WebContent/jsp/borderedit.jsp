<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<p>
		</div>
		<div align="center">
			<div><h3>글 내용 보기</h3><p></p></div>
			<form id="frm" name="frm" action="BorderEditWrite.do" method="post" >
				<input type="hidden" name="id" value="${dto.bNo }">
			<table border="1">
				<tr>
					<td width="100" align="center">글 번 호</td>
					<td width="640">${dto.bNo }</td>
				</tr>
				<tr>
					<td align="center">작 성 자</td>
					<td>${dto.writer }</td>
				</tr>
				<tr>
					<td align="center">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
					<td>${dto.subject }</td>
				</tr>
				<tr>
					<td align="center">내&nbsp;&nbsp;&nbsp;&nbsp;용</td>
					<td height="150"><textarea name="contents" rows="10" cols="90">${dto.contents }</textarea></td>
				</tr>
				<tr>
					<td align="center">작성일자</td>
					<td>${dto.wdate }</td>
				</tr>
			</table>
			<div><p></div>
			<div>
			<button type="submit">저 장</button>&nbsp;&nbsp;&nbsp;&nbsp;  
			<button type="button" onclick="location.href='BorderList.do'">취 소</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>