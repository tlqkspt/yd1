<%@page import="java.util.Enumeration"%>
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
		Enumeration enumeration = session.getAttributeNames();
		while(enumeration.hasMoreElements()) {
			String sName = enumeration.nextElement().toString();
			String sValue = (String)session.getAttribute(sName);
			
			if(sValue.equals("abcd")) 
			//session.removeAttribute(sName);	//세션 abcd 면 삭제해라
			session.invalidate();		//세션의 모든 데이터삭제
		}
	%>
	<h1>로그아웃 됨</h1>
	<a href="welcom.jsp">sessionTest</a>
</body>
</html>