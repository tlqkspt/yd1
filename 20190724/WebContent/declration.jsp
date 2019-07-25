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
     int i = 10;
     String str = "ABCDE";
%>

<%!
     public int sum(int n, int m) {
	       return ( n + m );
     }
%>
<%
     out.println(i + "<br />");
     out.println(str + "<br />");
     out.println(sum(10,20));
%>
</body>
</html>