<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>grid.jsp</title>
</head>
<body>
<div class="container" style="min-height: 600px;">
  <!-- Content here -->
  <div class="row align-items-start no-gutters">   <!-- row no-gutters   마진제거? -->
  	<div class="col border" style="height: 200px;">
		<h1 class="display-1">Display 1</h1>
		<h1>Display 1</h1>
	</div>
  	<div class="w-100"></div>
  	<div class="col-md-12 col-lg-3">왼쪽</div>		<!-- col-3 이면 모든해상도적용  전체너비는 12다  해상도따라 다르게? 만드는건 .col-sm-  등  부트스트랩사이트 참고 -->
  	<div class="col-md-12 col-lg-9 border px-5 py-5 text-center">오른쪽</div>		<!-- auto 자동으로 남는거계산? -->
  	<div class="w-100"></div>
  	<div class="col border">footer</div>
  	
  </div>
</div>

</body>
</html>