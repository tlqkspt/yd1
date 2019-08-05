<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	String path = request.getRealPath("fileupload");	//실제 파일이 저장될 위치
	
	int size = 1024 * 1024 * 10;	//10M	파일사이즈 html프로토콜? 기본 200메가
	String file = "";
	String oriFile = "";
	
	try {
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		
		file = multi.getFilesystemName(str);		//저장됨
		oriFile = multi.getOriginalFileName(str);
	} catch (Exception e) {
		e.printStackTrace();
	}

%>
ㄹㄹ?
</body>
</html>