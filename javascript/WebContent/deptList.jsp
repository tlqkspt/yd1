<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"   %>
<!DOCTYPE html>
<html><head><title>deptList.jsp</title></head>
<body>
<my:select name="departmentName"></my:select>
	<h3>부서등록</h3>
	<!-- 등록폼 시작 -->
	<form action="dept_control.jsp" method="post">
		<input type="hidden" name="action" value="insert"/>
		부서번호<input type="text" name="department_id"/>
		부서명<input type="text" name="department_name"/><br/>
		메니저<input type="text" name="manager_id"/>
		지역<input type="text" name="location_id"/>
		<input type="submit" value="등록"/><br/><input name="">
	</form>
	<!-- 등록폼 끝 -->
	<hr>
	<!-- 검색폼 시작 -->
	<div style="border: 1px solid gray">
		<form name="searchFrm" action="DeptListPagingServ">
		    <input type="hidden" name="p" value="1"/>
			메니저<input type="text" name="managerId" value="${param.managerId }"/>
			지역  <input type="text" name="locationId" value="${param.locationId }"/>
			<input type="submit" value="검색"/><br/>
		</form>
	</div>
	<!-- 검색폼 끝 -->
	
	<h3>부서목록</h3>
	<table>
		<tr>
			<th>부서번호</th>
			<th>부서명</th>
			<th>메니저</th>
			<th>지역</th>
		</tr>
		<c:forEach items="${list}" var="vo">
		<tr>
			<th>${vo.departmentId}</th>
			<th>${vo.getDepartmentName()}</th>
			<th>${vo.getManagerId()}</th>
			<th>${vo.getLocationId()}</th>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 -->
	<my:paging jsfunc="doList" paging="${paging}"/>	<!-- 태그파일로부름 // 태그파일은 WEB-INF/tags 폴더 안에 넣어야함-->
	<script>
	function doList(p) {
		document.searchFrm.p.value = p;
		document.searchFrm.submit();
	}
	</script>
</body>
</html>