<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><jsp:include page="topmenu.jsp"></jsp:include></div>
		<div>
			<p>
		</div>
		<div align="center">
			<div>
			<h3>목록보기</h3>
			<p>
			<table border="1">
				<tr align="center">
					<td width="50">글번호</td>
					<td width="100">작성자</td>
					<td width="200">제 목</td>
					<td width="100">작성일자</td>
					<td width="50">조회수</td>
				</tr>
				<c:forEach items="${list }" var="dto">
					<c:if test="${dto.bNo == null }">
						등록된 글이 없습니다.
					</c:if>
					<c:if test="${dto.bNo != null }">
						<tr align="center" onmouseover="this.style.background='#bbbbbb'" onmouseout="this.style.background='white'"
							onclick="location.href='BorderContents.do?id=${dto.bNo}'">
							<td>${dto.bNo }</td>
							<td>${dto.writer }</td>
							<td>${dto.subject }</td>
							<td>${dto.wdate }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:if>
				</c:forEach>
			</table></div>
			<div><p></div>
			<div>
				<button type="button" onclick="location.href='jsp/borderinsert.jsp'">글쓰기</button> 
			</div>
		</div>
	</div>
</body>
</html>