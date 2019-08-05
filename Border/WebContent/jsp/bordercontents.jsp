<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function formSubmit(n){
		
		var form = document.frm;
		if(n == 1){
			form.action="BorderEdit.do";
		} else {
			form.action="BorderDelete.do";
		}
		form.submit();
	}
	
</script>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<p>
		</div>
		<div align="center">
			<div><h3>글 내용 보기</h3><p></p></div>
			<form id="frm" name="frm" method="post" >
			<table border="1">
				<tr>
					<td width="100" align="center">글 번 호</td>
					<td width="640"><input name="id" value="${dto.bNo }" readonly></td>
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
					<td height="150">${dto.contents }</td>
				</tr>
				<tr>
					<td align="center">작성일자</td>
					<td>${dto.wdate }</td>
				</tr>
				<tr>
					<td align="center">첨부파일</td>
					<td><a href= "fileupload/${dto.fileName }">${dto.fileName }</a></td>
				</tr>
				<tr>
					<td align="center">조 회 수</td>
					<td>${dto.hit }</td>
				</tr>
			</table>
			<div><p></div>
			<div>
			<button type="button" onclick="formSubmit(1)">글 수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="formSubmit(0)">글 삭제</button>&nbsp;&nbsp;&nbsp;&nbsp;  
		
			<button type="button" onclick="location.href='BorderList.do'">목록</button>
			</div>
			</form>
		</div>
	</div>
</body>
</html>