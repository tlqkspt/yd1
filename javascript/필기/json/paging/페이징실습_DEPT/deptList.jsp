<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="dept.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head><title>부서목록</title></head>
<body>
<table border='1'>
<c:forEach var="i" items="${deptList}">
	<tr>
		<td>${i.departmentId}</td>
		<td><a href="deptUpdate.jsp?departmentId=${i.departmentId}">
		     ${i.departmentName}</a></td>
		<td>${i.managerId}</td>
		<td>${i.locationId}</td>
	</tr>
</c:forEach>
<!-- 페이징 -->
	<tr><td colspan="4">
	<c:forEach begin="1" end="${pageCnt}" varStatus="st">
		<c:if test="${param.p != st.count}">
		<a href="deptList.do?p=${st.count}">${st.count}</a>
		</c:if> 
		<c:if test="${param.p == st.count}">
			${st.count}
		</c:if>
	</c:forEach>
	</td></tr>
</table>
</body>
</html>