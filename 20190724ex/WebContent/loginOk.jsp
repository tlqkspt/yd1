<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String key;
	String value;
	String id;
%>
<%
	Cookie[] cookie = request.getCookies();		//쿠키 값 가져오기
	String[] str = null;
	for(int i = 0; i < cookie.length; i++) {
		key = cookie[i].getName();
		value = cookie[i].getValue();
		if(key.equals("id")){
			id = value;
			out.print(value + "님 환영합니다.<br />");
		} else {
			out.print(key + ":" + value + "<br />");
		}
	}
	
%>

<h1> <%= id %>로그인 성공 헀다.</h1>

<a href="logout.jsp">로그아웃</a>

</body>
</html>