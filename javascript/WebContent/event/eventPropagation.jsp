<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eventPropagation.jsp</title>
<style>
	div { padding: 50px; margin: 50px; border: 1px solid blue;}
</style>



<script>

//////////////////////////////////////////////////////////js 표현

function init(){	//펑션 여러번 불러쓰거나 너무길어지면 따로만들어 불러주면됨
	
}
window.onload = function(){	//여기 바로뒤에 function은 익명함수임
	var child = document.getElementById("child");
	var parent = document.getElementById("parent");
	var grand = document.getElementById("grnad");
	child.addEventListener("click", doChildClick ); //타입 핸들러 순으로	//괄호들어가면안됨 함수선언?됨	
	child.addEventListener("click", function(){		//add 말고 remove 도있다 해주면 모든??? 이벤트 삭제됨
		alert("두번째 핸들러");
	} );
	parent.addEventListener("click", function(){
		alert("parent click!!");
	});
	
};	
	
function doChildClick(e){		//e 라는 이벤트받아옴
	e.stopPropagation(); //이벤트 전파중지!  stopPropagation
	alert("child Click!!");
};



</script>
</head>
<body>
<h1>이벤트 전파 실습</h1>
<div id="grand">grand
	<div id="parent">parent
		<div id="child">child</div>
	</div>
</div>
</body>
</html>