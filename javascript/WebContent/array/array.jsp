<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
//문자열 분리해서 배열에 넣기
	var str2 = "가,나,다,라";
	var arr = str2.split(",");
	console.dir(arr);
	
//문자열 합치기 
	var s1 = arr.join("-");
	console.log( typeof s1);
	console.log(s1);
	
	window.onload = function(){
//배열의 값을 출력
		for(i=0; i<arr.length; i++){
			//태그 찾기 getElementById,	//내용변경 innerHTML
			var d = document.getElementById("result");	//.innerHTML = arr[i]+"<br>";
			d.innerHTML += arr[i] +"<br>"; 
		}
	};
	
</script>
</head>
<body>
<div id ="result">

</div>
</body>
</html>