<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	$("tr:gt(0)").each(function(){
		var total = 0;
		$(this).find("td:lt(3)").each(function(){ 
			total += parseInt($(this).text());
		});
		$(this).find("td:eq(3)").text(total);
	});
	// 이벤트 행을 클릭하면 합계를 alert
	$("td").click(function(){	
		alert("합계 "+$(this).parent().children().last().text());
		//$(this).parent().find("td").last().text()
	});
	
	$("tr:gt(0)").click(function(){  
		alert("국어 "+ $(this).find("td").first().text());
	});
	
});
</script>
</head>
<body>
	<table border>
		<tr><td>국어</td><td>영어</td><td>수학</td><td>합계</td></tr>
		<tr><td>80</td><td>90</td><td>90</td><td></td></tr>
		<tr><td>90</td><td>70</td><td>70</td><td></td></tr>
		<tr><td>60</td><td>80</td><td>80</td><td></td></tr>
	</table>
</body>
</html>