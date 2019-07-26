<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="student" class="co.kdw.student.Student" scope="page"></jsp:useBean>
<jsp:setProperty property="name" name="student" value="홍길동"/>
<jsp:setProperty property="studentNo" name="student" value="20190010001"/>

<jsp:getProperty property="name" name="student"/> <p>
<jsp:getProperty property="studentNo" name="student"/>
</body>
</html>