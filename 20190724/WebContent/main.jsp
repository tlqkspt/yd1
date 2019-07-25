<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 이곳에서 JSP를 사용했다. -->
<jsp:include page="footer.jsp"></jsp:include>
우리는 민족 중흥의 역사적 <br />
사명을 띄고 이땅에 태어났다<br />

<jsp:include page="footer.jsp"></jsp:include>

<jsp:forward page="expression.jsp"></jsp:forward> <!-- 특정페이지로 이동 -->


</body>
</html>