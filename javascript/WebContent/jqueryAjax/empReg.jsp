<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empReg.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		$.getJSON("../DeptListServ",function(data){
			var str="";
			for(i=0; i<data.length; i++){
				str += '<option value="'+data[i].departmentId+'">'
						+ data[i].departmentName;
			}
			//$('[name="departmentId"]').html(str);   // 제이쿼리표현! //name 으로 찾는거 //아래랑같은표현임
			document.getElementById("departmentId").innerHTML = str;	// 자바스크립트표현? //id찾는거임
		});
		
		
		//document.getElementById("departmentId")[0].onchange = function(){}	//js표현
		$('[name="email"]').change( function(){			// jquery 표현
			//ajax 요청
			var email = $('[name="email"]').val();	//name 이 email인놈의 값가져옴
			var param = {email : email};	//"email=" +email변환해서 줘도된다?
			$.getJSON("../EmailCheck", param, function(data){	//비교할 email넘어가야함 param 에 태워서 보내줌
				//$("#result").html(data.result);	//true면 사용불가 false면사용가능
				if(data.result == "true"){
					document.getElementById("result").innerHTML = "사용불가";	//js 표현
					document.getElementById("result").style.color = "red";
				} else{
					$("#result").html("사용가능");		//jquery 표현
					$("#result").css("color","blue");
				}
			})	
		})	
		
		
	});
</script>
</head>
<body>
<h3>사원등록</h3>
이름<input name="firstName"><br>
이메일<input name="email"><span id="result"></span><br>  <!-- span에서 중복검사할거 <input 안에 onchange 쓰는거 권장 x-->
부서 <select name="departmentId" id="departmentId">		<!--  html 쪽은 간단하게쓴다 -->
		<!-- <option value=""></option>  -->
	</select>
<button>등록</button>
</body>
</html>