<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eventOn.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
.highlight { color : white; background-color: gray; }
</style>
<script>
$(function(){
	$("ul").on("mouseover mouseout", "li", function(){	//   $("li").bind("mouseover mouseout" , function(){ 이건 새로생긴거에는 안들어감
		$(this).toggleClass("highlight");						//가운데있으면 앞에꺼에 위임
	})
	$("button").bind("click", function(){
		$("ul").append($("<li>").html("스프링"));
	})
});
</script>
</head>
<body>
<h1>on 함수 연습</h1>
<button type="button">도서추가</button>
<ul>
	<li>자바
	<li>jsp
	<li>jquery
</ul>
</body>
</html>