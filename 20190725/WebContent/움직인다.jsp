<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>움직이는글자</title>
</head>



<body>
   
   
	<%!String first;
	   String last;
	   List<String> list = new ArrayList<>();
	   String all = " ";   
	%>
	<%
		list.add("a");
		list.add("b");
		list.add("c");
	
	%>
	<script>
	 function sss(){
	<%
		
		first = list.get(0);
		list.remove(0);
		list.add(first);
		
		
		for(String a : list)
		all += a;
	%>
  }
   </script>

	<script>
		function qqq() {
			sss();
			var result = <%= all %>;
			document.getElementById("hhh").innerHTML = result;

		}
	</script>
	<input type="button" value="N 팩토리얼 계산" onclick="qqq()">
	<p id="hhh">절대 위치 설정 적용 - "PrintString()"</p>
	<%= first %>
</body>
</html>