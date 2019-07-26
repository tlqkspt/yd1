<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>  <!-- 에러처리하는 페이지라고 나타내는것 (기본값은 false다) -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setStatus(200);	//내상태는 정상상태라고 인식을 시켜준다
	
%>
</body>
<h1>어머나!! 오류네요, 관리자에게 문의하세요.</h1>
<%= exception.getMessage() %>
</html>