<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//태그쓰면안됨  데이터만 넘겨줌
	//Thread.sleep(2000);
	String userid= request.getParameter("userid");
	if(userid.equals("admin")){
		out.print("사용불가");
	} else {
		out.print("사용가능");
	}
	//out.print("async test");
%>