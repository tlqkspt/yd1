<%@page import="co.kdw.student.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
	ResultSet rs;
	Student st;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "kdw";
	String password = "1234";
	String sql = "select * from member00";
	ArrayList<Student> list;
	
%>

<%
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		psmt = conn.prepareStatement(sql);
		rs = psmt.executeQuery();
		list = new ArrayList<Student>();
		while(rs.next()){
			st = new Student();
			st.setId(rs.getString("id"));	//id
			st.setName(rs.getString("name"));	//name
			st.setTel(rs.getString("tel"));	//tel
			st.setAddr(rs.getString("addr"));	//addr
			list.add(st);			//여기다 dto쓴다
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>

<h3>학생명부</h3>
<table border="1">
	<tr>
		<th align="center" width="150">아이디</th>
		<th align="center" width="150">성  명</th>
		<th align="center" width="150">전화번호</th>
		<th align="center" width="150">주소</th>
	</tr>
			
<%		
	for(Student s : list) {
%>
	<tr>
		<td align="center"> <%= s.getId() %> </td>
		<td align="center"> <%= s.getName() %> </td>
		<td align="center"> <%= s.getTel() %></td>
		<td align="center"> <%= s.getAddr() %></td>
	</tr>
<%	}
%>
</table>
<br>&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" onclick="location.href ='index.jsp'">처음으로</button>&nbsp;&nbsp;
<button type="button" onclick="location.href ='insert.jsp'">추가하기</button>&nbsp;&nbsp;
<button type="button" onclick="location.href ='delete.jsp'">삭제하기</button>&nbsp;&nbsp;
<button type="button" onclick="location.href ='update.jsp'">수정하기</button>

</body>
</html>