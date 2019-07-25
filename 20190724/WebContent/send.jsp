<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
 
	String gender;
	request.setCharacterEncoding("utf-8");
    gender = request.getParameter("gender");
   
         
    if(gender.equals("남")){
    	 response.sendRedirect("a.jsp");
    	 }
    else
    	 response.sendRedirect("print.jsp");
  
--%>


<% response.sendRedirect("output.jsp"); %>
</body>
</html>