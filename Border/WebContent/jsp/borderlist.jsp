<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/common.js"></script>
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
				<form name="frm" id="frm" action="BorderContents.do" method="post">
					<input type="hidden" name="id">
					<table border="1">
						<tr align="center">
							<td width="50"><button type="button" onclick="BorderList.do">글번호</button></td>
							<!--  <td width="50">글번호</td>  -->
							<td width="100">작성자</td>
							<td width="250">제 목</td>
							<td width="100">작성일자</td>
							<td width="150">첨부파일</td>
							<td width="50">조회수</td>
						</tr>
						<c:forEach items="${list }" var="dto">
							<c:if test="${dto.bNo == null }">
						등록된 글이 없습니다.
					</c:if>
							<c:if test="${dto.bNo != null }">
								<tr align="center" onmouseover="this.style.background='#bbbbbb'"
									onmouseout="this.style.background='white'"
									onclick="formSubmit(${dto.bNo })">
									<td>${dto.bNo }</td>
									<!-- value="${dto.bNo }" -->
									<td>${dto.writer }</td>
									<td>${dto.subject }</td>
									<td>${dto.wdate }</td>
									<td>${dto.fileName }</td>
									<td>${dto.hit }</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</form>
			</div>
			<div>
				<p>
			</div>

			<!-- 페이징 테스트 test -->
			<div class="pager">
				<ul>
					<c:if test="${ curPageNum > 5 && !empty kwd }">
						<li><a
							href="/mysite/board?page=${ blockStartNum - 1 }&kwd=${ kwd }">◀</a></li>
					</c:if>

					<c:if test="${ curPageNum > 5 }">
						<li><a href="/mysite/board?page=${ blockStartNum - 1 }">◀</a></li>
					</c:if>

					<c:forEach var="i" begin="${ blockStartNum }"
						end="${ blockLastNum }">
						<c:choose>
							<c:when test="${ i > lastPageNum }">
								<li>${ i }</li>
							</c:when>
							<c:when test="${ i == curPageNum }">
								<li class="selected">${ i }</li>
							</c:when>
							<c:when test="${ !empty kwd}">
								<li><a
									href="/mysite/board?a=search&page=${ i }&kwd=${ kwd }">${ i }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="/mysite/board?page=${ i }">${ i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${ lastPageNum > blockLastNum && !empty kwd }">
						<li><a
							href="/mysite/board?a=search&page=${ blockLastNum + 1 }&kwd=${ kwd }">▶</a></li>
					</c:if>

					<c:if test="${ lastPageNum > blockLastNum }">
						<li><a href="/mysite/board?page=${ blockLastNum + 1 }">▶</a></li>
					</c:if>
				</ul>
			</div>
			<!-- 페이징 테스트 end. -->



			<div>
				<c:if test="${name != null }">
					<button type="button" onclick="location.href='Writer.do'">글쓰기</button>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>