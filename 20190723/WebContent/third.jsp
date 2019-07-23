<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
1 부터 10 까지 순차적으로 출력하기</br>
<%
     for(int i=1; i<=10; i++) {
           System.out.println(i);
%>
     &nbsp;&nbsp;&nbsp;i = <%=i %> </br>
<% } %>

</body>
</html>