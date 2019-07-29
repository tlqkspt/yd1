<%@page import="co.kdw.student.Student"%>
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
	Student st;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kdw";
	String password = "1234";
	String sql;
	int n;
	
%>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String addr = request.getParameter("addr");
	sql = "insert into member00 values(?,?,?,?,'산업공학')";
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, name);
		psmt.setString(3, tel);
		psmt.setString(4, addr);
		n = psmt.executeUpdate();	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	if(n != 0) {
		response.sendRedirect("list.jsp");
	} else {
		out.print("입력이 실패 되었습니다.!!!! <p>");
	}
%>

<a href="index.jsp">메뉴로 가기</a>

</body>
</html>