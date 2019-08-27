<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function() {
		//배열 선언
		var arr = [ "../img/Desert.jpg", 
				"../img/Hydrangeas.jpg",
				"../img/Lighthouse.jpg" ];

	//	for (i = 0; i < arr.length; i++) {
	//		var d = document.getElementById("result");		//.innerHTML += "<img src=" + arr[i] + ">";
	//		d.innerHTML += "<img src='"+arr[i]+"'>"		//	'"+arr[i]+"' 작은따옴표 큰따옴표 위치바꿔도됨  
	//	}
		
		//이미지파일명 배열에서 읽어 하나의 문자열로 만들수도있다
		
		let str = "";
		
		arr.forEach(f);
		
		function f(value,index){
			str += "<img src='"+value+"'/>"
		}
		
		document.getElementById("result").innerHTML = str;
		
		
	}
</script>
</head>
<body>
	<div id="result"></div>
</body>
</html>