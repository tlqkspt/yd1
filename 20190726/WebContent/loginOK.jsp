<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("abcd") && pw.equals("1234")){
		session.setAttribute("id", id);
		response.sendRedirect("welcom.jsp");
	}
//		out.print("<h1>" + id + "님 환영합니다." + "</h1>");
	else
		response.sendRedirect("login.html");
		
		
%>
</body>
</html>