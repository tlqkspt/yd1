<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 img {left:0px; top:0px; width:20px; position:relative;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	let direction;
	$(function(){
		$("body").bind("mousedown",function(e){
			console.log(e.clientX + " : " + e.clientY);
			$("#img1").css("left", e.clientX+"px");
			$("#img1").css("top", e.clientY+"px");
		});
		
		$("body").bind("keydown", function(e){
			console.log(e.keyCode);
			direction = e.keyCode;
			if(e.keyCode == 37){
				var left = parseInt($("#img1").css("left")) - 20;
				$("#img1").css("left", left+ "px");
			}else if(e.keyCode == 38){
				var left = parseInt($("#img1").css("top")) - 20;
				$("#img1").css("top", left+ "px");
			}else if(e.keyCode == 39){
				var left = parseInt($("#img1").css("left")) + 20;
				$("#img1").css("left", left+ "px");
			}else if(e.keyCode == 40 ){
				var left = parseInt($("#img1").css("top")) + 20;
				$("#img1").css("top", left+ "px");
			}else if(e.keyCode == 32 ){
				var left = parseInt($("#img1").css("top")) + 500;
				$("#img1").css("top", left+ "px");
			}
		});
		setInterval(imgMove, 1000);
	});
	
	function imgMove(){
		var move = 20;
		if(direction == 37){
			var left = parseInt($("#img1").css("left")) - 20;
			$("#img1").css("left", left+ "px");
		}else if(direction == 38){
			var left = parseInt($("#img1").css("top")) - 20;
			$("#img1").css("top", left+ "px");
		}else if(direction == 39){
			var left = parseInt($("#img1").css("left")) + 20;
			$("#img1").css("left", left+ "px");
		}else if(direction == 40 ){
			var left = parseInt($("#img1").css("top")) + 20;
			$("#img1").css("top", left+ "px");
		}else if(direction == 32 ){
			var left = parseInt($("#img1").css("top")) + 500;
			$("#img1").css("top", left+ "px");
		}
	}
	
	
</script>
</head>
<body>
<img id="img1" src="./img/Koala.jpg"/>
</body>
</html>