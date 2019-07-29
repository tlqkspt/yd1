<%@page import="java.sql.ResultSet"%>
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
<script>
	function winClose(n){

//		if(!chkId ) opener.document.getElementById("chk").value = "idChk";	//id로 찾는거
//		opener.document.frm.chk.value = "idChk";	//네임으로찾는거
//		
		
		if(n == 1){
			opener.document.getElementById("chk").value = "idChk";	//opener 부모호출?
		} else {
			opener.document.frm.chk.value = '';
		}
		self.close();
	}
</script>
</head>

<body>
<%!
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="kdw";
	String password="1234";
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	String id;
	String chkId;
	int n = 0;
%>

<%
	id = request.getParameter("id");
	sql = "select memberid from member where memberid = ?";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		rs = psmt.executeQuery();
		while(rs.next()){
			chkId = rs.getString(1);		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		rs.close();
		psmt.close();
		conn.close();
	}
	
	if(chkId.equals(id)) {
		out.print("<h3> 이미 사용하는 아이디 입니다. </h3>");
		n=0;
	} else {
		out.print("<h3>"+id+" 는 사용 가능 합니다.</h3>");
		n=1;
	}
	
	//chkId = false;	//없으면 중복확인 이미 존재하는 아이디 검사후 없는아이디 검사하면 있다고나옴  위에 클로즈춫가
%>

<p>
<input type = "button" value="확인" onclick="winClose(<%= n %>)">



</body>
</html>