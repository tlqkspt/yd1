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
     int[] i = {1,2,3};
%>

<%
    out.print(i[0] + "<br />");
	out.println(i[1]);
	out.println(i[2]);
	
%>
</body>
</html>