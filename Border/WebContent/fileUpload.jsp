<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileFormOk.jsp" method="post" enctype="multipart/form-data">  <!-- enctype="multipart/form-data" html 파일 선택?할때 꼭써줘야함 -->
		파일 :<input type="file" name="file"><br />
		<input type="submit" value="File Upload">
	</form>
	ㅇ?
</body>
</html>