<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<%
	String name= (String) session.getAttribute("name");	//세션 정보 얻기
	String id= (String) session.getAttribute("id");	//세션 정보 얻기
%>
<body>
<div align="center">
		<div id="menu" align="center">
			<nav id="topMenu">
				<ul>
					<li class="topMenuLi"><a class="menuLink" href="Index.do">홈</a>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="LoginForm.do">로그인</a>
						</li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="#">회원가입</a>
						<ul class="submenu">
							<li><a href="MemberList.do" class="submenuLink">회원목록</a></li>
							<li><a href="MemberInForm.do" class="submenuLink">회원등록</a></li>
							<li><a href="#" class="submenuLink">회원수정</a></li>
							<li><a href="#" class="submenuLink">회원삭제</a></li>
						</ul></li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="BorderList.do">자유게시판</a></li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="LogOut.do">로그아웃</a></li>
				</ul>
			</nav>
		</div>
		<div id="idcheck" align="right">		<!-- 로그인 표시용 -->
			<c:if test = "${sid != null }">
				ID:${name }
			</c:if>
			<c:if test = "${sid == null }">
				손님
			</c:if>
		</div>
	</div>
</body>
</html>