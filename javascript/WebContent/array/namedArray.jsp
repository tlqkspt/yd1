<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>namedArray.jsp</title>
<script>
	var emp = [];	//new Array;
	emp["firstName"] = "scott";			//자바 스크립트는 emp.firstName 이나 emp[firstName] 이나 같은거로 인식함
	emp["salary"] = 3000;
	emp["dept"] = "총무";
	
	console.dir(emp);
	document.write("<hr>");
	
	for(i in emp){
		document.write(i + " : " + emp[i] + "<br>");		
	}
</script>
</head>
<body>

</body>
</html>