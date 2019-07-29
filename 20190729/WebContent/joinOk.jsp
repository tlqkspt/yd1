<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="kdw";
	String password="1234";
	
	Connection conn;
	PreparedStatement psmt;
	String sql;
	
	String username;
	String userid;
	String userpw;
	String birth;
	String addr;
	int n;
%>

<%
	request.setCharacterEncoding("utf-8");
	username = request.getParameter("name");
	userid = request.getParameter("id");
	userpw = request.getParameter("password");
	birth = request.getParameter("birth");
	addr = request.getParameter("addr");
//	Date now = new Date();
	Date birthday = Date.valueOf(birth);
	
//	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//	java.sql.Date s = new java.sql.Date(now.getTime());

	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		sql="insert into member values(?,?,?,?,?)";
		psmt = conn.prepareStatement(sql);
		psmt.setString(1,userid);
		psmt.setString(2, userpw);
		psmt.setString(3, username);
		psmt.setString(4, addr);
		psmt.setDate(5, birthday);
		n = psmt.executeUpdate();
	} catch (SQLException e){
		response.sendRedirect("join.html");
	}
	
	response.sendRedirect("joinResult.jsp");

%>


</body>
</html>