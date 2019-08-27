<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// var 보다 let쓰는걸 권장
	let arr = ["바나나","사과","포도","키위","바나나"];
	let arr2 = [];
	//arr --> arr2로 이동(복사x)
	var length = arr.length;
	for(i=0; i<length; i++) {		//arr.length 는 arr.pop()하면 값이 변하기때문에 2번하고 끝남
		
		let temp = arr.shift();
		arr2[temp] = temp;
		
		//arr2.push(arr.pop());		//shift()
	}
	//document.write("arr: " + arr +"<br>");
	//document.write("arr2:" + arr2 + "<br>");
	
	document.write("arr: " + arr +"<br>");
	for(i in arr2){
		document.write(i + " : " + arr2[i] + "<br>");
	}
</script>

</head>
<body>

</body>
</html>