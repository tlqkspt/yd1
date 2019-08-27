<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boxOffice.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

	function loadDoc(){
		var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20190825";
	/* 	$.getJSON(url, function(data){	//function()  << 여기넣는 인수값이 data			///  $.get  $.getJSON???????
		
		//var result = JSON.parse(data);	//this.responseText >>>> data		// 데이터가 파싱되서 오기때문에 안해줘도된다?
    	
    	var list = data.boxOfficeResult.dailyBoxOfficeList;
     	var str = "<table border>";
    	for(i=0; i<list.length; i++){
    		str += "<tr>" +  "<td>" + list[i].rank + "</td>" + "<td>" +  list[i].movieNm + "</td>" +"</tr>";			
    	}
      	
      	str += "</table>";
      	document.getElementById("demo").innerHTML = str;
	}); */
	
		$.ajax( {
			url : url,	// $.ajax( 안에넣어도됨
			method : "get",
			//data :		//data있으면 넣어주면됨
			dataType : "json"	//, success: 해줘도되고	.done().... 해도됨  << 이걸더많이씀
		}).done(function(data){		//성공적으로 실행했을때
			    	var list = data.boxOfficeResult.dailyBoxOfficeList;
			     	var str = "<table border>";
			    	for(i=0; i<list.length; i++){
			    		str += "<tr>" +  "<td>" + list[i].rank + "</td>" + "<td>" +  list[i].movieNm + "</td>" +"</tr>";			
			    	}
			      	
			      	str += "</table>";
			      	document.getElementById("demo").innerHTML = str;
		}).fail(function(xhr,code){			///실패했을때
			document.getElementById("demo").innerHTML = code;
		}).always(function(){				//finally 와 같음 
			console.log("always 실행ㅇㅇㅇㅇ");
		});
  }
</script>
</head>
<body>
<button type="button" onclick="loadDoc()">영화예매순위</button>
<div id="demo"></div>


</body>
</html>