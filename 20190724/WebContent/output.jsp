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
	String name;
	String addr;
	String tel;
	String[] hobby;
	String gender;
	String major;
	int i;
	int size;
%>

<%
	request.setCharacterEncoding("utf-8");  //넘어온 한글처리(깨지지않게해줌)
	id = request.getParameter("id");  //뒤에있는친구 form.jsp에 id 랑 같아야함
	name = request.getParameter("name");
	addr = request.getParameter("addr");
	tel = request.getParameter("tel");
	hobby = request.getParameterValues("hobby");
	major = request.getParameter("major");
	gender = request.getParameter("gender");
	size = hobby.length;
	
%>
===============================<br>
사용자 ID : <%= id %> <br />
사용자 이름: <%= name %> <br />
사용자 주소: <%= addr %> <br />
전 화 번 호: <%= tel %> <br />
취       미: 
<% for(i = 0; i < size; i++ ) { %>
	<%= hobby[i] %>
<% } %>  <br />
사용자 성별:<%= gender %> <br />
사용자 전공:<%= major %> <br />
</body>
</html>