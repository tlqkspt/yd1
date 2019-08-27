<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$( function(){  // == $(document).ready( function(){ 랑같음	
	$("#btn").click(function(){   //click() 이벤트핸들러
		$("img").width("200");	
	});
});

</script>
</head>
<body>
<button id="btn">그림크기변경</button><br>
<img src="../img/Chrysanthemum.jpg">
<img src="../img/Hydrangeas.jpg">
<img src="../img/Jellyfish.jpg">
</body>
</html>