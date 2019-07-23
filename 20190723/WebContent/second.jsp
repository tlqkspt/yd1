<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
    int n = 10;
    int m = 100;
    int max;
%>

<%
    if(n > m) max = n;
    else 
    	 max = m;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
n 의 값 : <%= n %><br>
m 의 값 : <%= m %><br>
두값중 더큰값은 : <%= max %>
</body>
</html>