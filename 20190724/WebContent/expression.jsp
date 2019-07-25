<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<!-- jsp 변수 및 함수 정의 -->
<%!
     int i = 10;
     String str = "ABCDE";
       
     public int sum(int n, int m) {
    	 return n+m;
     }
%>

<%=i %><br />
<%= str %><br / >
합계<%= sum(10,20) %>

</body>
</html>