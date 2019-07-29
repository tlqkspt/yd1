<%@page import="com.sun.org.apache.xml.internal.serialize.Printer"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
	function alert(){
		alert("아이디 값을 입력하세요");
	}
			
	</script>
</head>
<body>
	<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kdw";
	String password = "1234";

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs = null;
	String sql;

	String userid;
	String userpw;
	int n;
	String loginOk = "0";
	%>

	<%
		request.setCharacterEncoding("utf-8");
		userid = request.getParameter("id");
		userpw = request.getParameter("pw");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			sql = "select * from member where memberid = ? and password = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			psmt.setString(2, userpw);
			rs = psmt.executeQuery();

			while (rs.next()) {
				out.print(rs.getString("memberid"));
				loginOk = "1";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			psmt.close();
			conn.close();
		}

		if (loginOk.equals("1"))
			response.sendRedirect("loginResult.jsp");
		else {
			response.sendRedirect("login.html");
			%> alert() <%
		}
		loginOk = "0";
	%>
</body>
</html>