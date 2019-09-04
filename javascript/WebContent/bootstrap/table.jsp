<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>table.jsp</title>
</head>
<body>
<button class="btn btn-danger btn-block">버튼</button>
<a href="#" class="btn btn-danger">페이지이동</a>

<div class="alert alert-primary" role="alert">
  A simple primary alert—check it out! <a href="grid.jsp" class="alert-link">grid.jsp</a>.
</div>

	<table class="table table-striped table-bordered table-hover">
		<thead class="thead-dark">
			<tr><th>국어</th><th>영어</th><td>수학</td><td>합계</td></tr>
		</thead>
		<tbody>
			<tr class="table-primary"><td>80</td><td>90</td><td>90</td><td></td></tr>
			<tr><td>90</td><td class="bg-success">70</td><td>70</td><td></td></tr>
			<tr><td>60</td><td>80</td><td>80</td><td></td></tr>
		</tbody>
	</table>
</body>
</html>