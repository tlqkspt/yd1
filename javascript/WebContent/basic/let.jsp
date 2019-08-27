<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>let.jsp</title>
<script>
	//"use strict";		//var 안쓰면 안되게??
	var g = 10;
	function sum(){
		var l = 20;		//지역
		var g = 30;
		
	//	b = 3;	 		//전역	//var 는 써주는게좋다
	}
	
	sum();
	//document.write(b+"<br>");
	//document.write(g);
	//document.write(l);
	
	///// var let 차이
	
	var a = 40;
	
	{
		var a = 50;
	}
	
	document.write(a+"<br>");
	
	let b = 40;
	
	{
		let b = 50;
	}
	
	document.write(b);
	
	//전역변수
	let g = 10;
	
	//블록변수
	{
		let g = 20;
	}
	
	function sum(){
		//지역변수
		let d = 10;
	}
	
	document.write(g);

</script>
</head>
<body>

</body>
</html>