<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxAsync.jsp</title>
<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 ) {	//4 .콜백함수가 완료
    	if(this.status == 200){
    		document.getElementById("demo").innerHTML = this.responseText;
    	}else{
    		document.getElementById("demo").innerHTML = this.status 
    													+":" + this.statusText; 
    	}
    } else {
    	document.getElementById("demo").innerHTML = "로딩중";
    }
  };
  
  var param = "userid=" + document.getElementById("userid").value;		//질의문자열
  xhttp.open("POST", "../server/ajax.jsp", true);	//true 비동기 false 동기		//get방식  "../server/ajax.jsp?"+param
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");	//post방식일때필요
  xhttp.send(param);	//동기면 블록킹 //동기  ajax 처리가 끝나고나서() 다음진행		//비동기 send()안기다리고 실행하다 응답오면 이벤트발생해서 화면에찍힘
  		   //post일때 send() 안에 param넣음
  console.log("ajax 요청 후");
}
</script>
</head>
<body>
<input id="userid"/>
<button type="button" onclick="loadDoc()">Change Content</button>
<div id="demo"></div>
</body>
</html>