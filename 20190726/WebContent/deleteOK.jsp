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
	Connection conn;
	PreparedStatement psmt;
	String id;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kdw";
	String password = "1234";
	String sql;
	int n;
%>

<%
	request.setCharacterEncoding("utf-8");
	String val = request.getParameter("val");
	String sel = request.getParameter("select");
	sql = "delete from member where "+sel+"= " + id;
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		psmt = conn.prepareStatement(sql);
		n = psmt.executeUpdate();
	} catch (SQLException e){
		e.printStackTrace();
	}
	
	if(n != 0) {
		response.sendRedirect("list.jsp");
	} else {
		out.print("삭제 실패!!<p>");
	}
%>

<a href = "index.jsp">메뉴</a>

</body>
</html>