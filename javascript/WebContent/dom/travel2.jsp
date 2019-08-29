<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travel2</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		$("span").hide();
		//마우스오버하면 span태그 보이게
		//mouseout span 숨기기
	/*	$("li").bind({"mouseover": function(){
										$(this).find("span").show();
									},
		               "mouseout": function(){
										$(this).find("span").hide();
									}
					}); 		*/
		
		$("li").bind("mouseover mouseout", function(){
				$(this).find("span").toggle();
		});
		
		
		
	});
</script>
</head>
<body>
<ul>
	<li>자바<span>2,000</span>
	<li>스프링<span>4,000</span>
	<li>자바스크립<span>3,500</span>
</ul>
</body>
</html>