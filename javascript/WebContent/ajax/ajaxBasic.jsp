<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

<div id="demo">
<h2>ajaxBasic.jsp</h2>
<button type="button" onclick="loadDoc()">Change Content</button>
</div>

<script>
function loadDoc() {
  var xhttp = new XMLHttpRequest();						//1단계
  xhttp.onreadystatechange = function() {				//
    if (this.readyState == 4 && this.status == 200) {  	//4 응답완료 되고 성공이면// this.status ==		500서버오류	
    	
    	document.getElementById("demo").innerHTML = this.responseText;
    	
      	var result = JSON.parse(this.responseText);	//this.responseText 응답결과
    	
    	var list = result.boxOfficeResult.dailyBoxOfficeList;
     	var str = "<table border>";
    	for(i=0; i<list.length; i++){
    		str += "<tr>" +  "<td>" + list[i].rank + "</td>" + "<td>" +  list[i].movieNm + "</td>" +"</tr>";			
    	}
      	
      	str += "</table>";
      	document.getElementById("demo").innerHTML = str;
    }
  };
  
  var url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=430156241533f1d058c603178cc3ca0e&targetDt=20190825";
  
  
  xhttp.open("GET", url, true);
  xhttp.send();
}
</script>

</body>
</html>
