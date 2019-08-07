<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/common.js"></script>		<!-- 히든변수에 값을 실는다 -->
</head>
<body>
	<div align="center">
		<div><jsp:include page="menu.jsp"></jsp:include></div>
		<div>
			<p>
		</div>
		<div align="center">
			<div>
			<h3>목록보기</h3>
			<p>
			<form name="frm" id="frm" action="BorderContents.do" method="post">
					<input type="hidden" name="id">	<!-- 레코드에 pk값 전달 -->
			<table border="1">
				<tr align="center">
					<td width="50"><button type="button" onclick="BorderList.do">글번호</button></td>  <!--  <td width="50">글번호</td>  -->
					<td width="100">작성자</td>
					<td width="250">제 목</td>
					<td width="100">작성일자</td>
					<td width="150">첨부파일</td>
					<td width="50">조회수</td>
				</tr>
				
				<c:forEach items="${list }" var="dto">
					<c:if test="${list != null }">
						<tr align="center" onmouseover="this.style.background='#bbbbbb'" onmouseout="this.style.background='white'"
							onclick="formSubmit(${dto.bNo })">
							<td>${dto.bNo }</td> <!-- value="${dto.bNo }" -->
							<td>${dto.writer }</td>
							<td>${dto.subject }</td>
							<td>${dto.wdate }</td>
							<td>${dto.fileName }</td>
							<td>${dto.hit }</td>
						</tr>
					</c:if>
				</c:forEach>
				<c:if test = "${list == null }">
				<tr>
					<td colspan="6" align ="center">헉; 없다</td>
				</tr>
				</c:if>
			</table></form></div>
			<div><p></div>
			<div>
				<c:if test="${sid != null }">
					<button type="button" onclick="location.href='Writer.do'">글쓰기</button>
				</c:if>	 
			</div>
		</div>
	</div>
</body>
</html>