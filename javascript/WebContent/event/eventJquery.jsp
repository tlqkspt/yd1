<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eventJquery.jsp</title>
<style>
	div { padding: 50px; margin: 50px; border: 1px solid blue;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){	//window.load(자바스크립트) 와동일
	var child = $("#child");
	var parent = $("#parent");
	var grand = $("#grand");
	child.click( doChildClick ); 	//단축형으로작성 //  == child.bind("click", doChildClick); 같은거임		//bind  ==  addEventListener와 같다
	child.on("click", function(){ alert("두번째 핸들러");});
	parent.bind("click", function(){alert("parent click!!");})
});
function doChildClick(e){		//e 라는 이벤트받아옴
	e.stopPropagation(); //이벤트 전파중지!  stopPropagation
	alert("child Click!!");
};
	
	
</script>

</head>

<body>
<h1>이벤트 전파 실습(jquery)</h1>
<div id="grand">grand
	<div id="parent">parent
		<div id="child">child</div>
	</div>
</div>
</body>
</html>