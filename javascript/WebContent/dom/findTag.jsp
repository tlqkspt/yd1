<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload = function(){	//페이지준비되면
	var btn = document.getElementById("btn");
	btn.onclick = function(){
		imgList = document.getElementsByTagName("img");
		for(i=0; i<imgList.length; i++){
			imgList[i].style.width="100px";
		}
	};
}
</script>
</head>
<body>
<button id="btn">그림크기변경</button><br>
<img src="../img/Chrysanthemum.jpg">
<img src="../img/Hydrangeas.jpg">
<img src="../img/Jellyfish.jpg">
</body>
</html>