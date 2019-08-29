<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainpulation 태그조작</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
div { border: 1px solid blue; padding: 50px; }
</style>
</head>
<body>
<div id="bucket"></div>
<div id="apple">사과</div>
<div id="banana">바나나</div>
<script>
$(function (){
	$bucket = $("#bucket");
	$apple = $("#apple");
	$banana = $("#banana");
	$body = $("body");
	//사과를 버킷으로 이동(.clone()하면 복사해서넣음)
	$bucket.append($apple.clone());     //.clone() 복사해서넣음
	
	//생성해서 추가	<div id="kiwi" style="color:green" onclick="">키위</div>
	var fruit = { cnt:1, no:10, name:"kiwi"}
	$("<div>").html("키위")	//html형식으로 넣으면 태그생성  그냥 $("div") 하면 div 태그 찾는거
			  .attr("id","kiwi")
			  .css("color", "green")
			  .bind("click",function(){  $(this).css("color", "red");     })
			  .data("p", fruit)	//객체값을 태그에저장?		.data("변수명", 값)
			  .appendTo($bucket);	//새로만든 태그 ()위치에 추가됨

	//생성 <button>삭제</button>   --클릭 >> bucket 삭제
	$("<button>").html("삭제")
	             .css("background-color","red")
	             .bind("click",function() {  $bucket.remove();  })
	             .appendTo($body);
});
</script>
</body>
</html>