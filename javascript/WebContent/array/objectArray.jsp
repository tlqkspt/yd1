<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//객체배열
var d = [ {name: 'choi', age:20 , hobby : ["독서","등산","산책" ] }
		 ,{name: 'park', age:30 }
		 ,{name: 'kim', age:10 }
		]
	//첫번째 회원의 이름은?
document.write("첫번째 회원의 이름은 " + d[0].name + "<br>");
document.write("두번째 회원의 나이는 " + d[1].age + "<br>");
document.write("첫번째 회원의 첫버째 취미는 " + d[0].hobby[0] + "<br>");

// 객체 >> 스트링 >> 객체
//서버에 넘길러면 object 면 안됨 string 으로 바꿔줘야함  		//parse    stringify

//정렬
//d.sort( function(a,b){ return a.age - b.age } );		//값 2개 받아와야함
d.sort( function(a,b){ return a.name - b.name } );		// 문자열 비교는 따로있다?
console.dir(d);

//  object -> string
let s = JSON.stringify(d);

// string -> object
let o = JSON.parse(s);

</script>
</head>
<body>

</body>
</html>