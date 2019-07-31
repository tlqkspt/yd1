<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function FormClose(n){
		if(n == 1) {
			opener.document.frm.chk.value = "idChk";
		} else {
			opener.document.frm.id.value ='';	//중복아이디면 id 입력칸을 빈칸으로 만듬
		}
		self.close();
	}
</script>

</head>
<body>
<div align="center">
<% 
	String dbid = (String)request.getAttribute("rid");	//db id
	String fid = (String)request.getAttribute("oldid");	//form id
	
	int n = 0;

	if(dbid != null){
		out.print("<h2>"+ dbid + "는 이미 사용하는 아이디 입니다.</h2><p>");
		n = 0;
	} else {
		out.print("<h2>" + fid + "는 사용가능한 아이디 입니다.</h2><p>");
		n = 1;
	}
%>

<button name="check" onclick="FormClose(<%= n %>);">확인</button>
</div>
</body>
</html>