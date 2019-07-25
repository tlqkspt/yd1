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
	String id;
    String pw;
%>

<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	
	if(id.equals("abcd") && pw.equals("1234")){
		Cookie cookie1 = new Cookie("id", id); //쿠키생성
		Cookie cookie2 = new Cookie("pw", pw);
		cookie1.setMaxAge(60);		//쿠키 유효기간 성정
		cookie2.setMaxAge(60);
		
		response.addCookie(cookie1);		//쿠키정보 담기
		response.addCookie(cookie2);
		
		response.sendRedirect("loginOk.jsp");
	} else {
		response.sendRedirect("index.html");
	}
%>
</body>
</html>