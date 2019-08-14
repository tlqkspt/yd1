<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function check(){
			if(document.frm.writer.value == ""){
				alert("작성자가먼저다");
				return false;
			}
			document.frm.submit();
		}
	</script>
</head>
<body>
<div align="center">
	<div><jsp:include page="topmenu.jsp"></jsp:include></div>
	<div><p></div>
	<div><h3>글 쓰기</h3></div>
	<div><p></div>
	<div>
		<form id="frm" name="frm" action="BorderInsert.do" method="post" enctype="multipart/form-data">
			<div><table border="1">
				<tr>
					<td align="center">작 성 자</td>
					<td><input type="text" id="writer" name="writer" value="${name }" readonly>
					     <input type="hidden" id="sid" name="sid" value="${sid }"></td>
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
					<td align="center">첨부파일</td>
					<td witdh="640"><input type="file" id="file" name="file"></td>
				</tr>
				</table></div>
				<div><p></div>
				<div>
					<button type="button" onclick="check()">확인</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='BorderList.do'">목록</button>
				</div>
		</form>
	</div>
</div>
</body>
</html>