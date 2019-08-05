<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div align="center">
		<div id="menu" align="center">
			<nav id="topMenu">
				<ul>
					<li class="topMenuLi"><a class="menuLink" href="index.jsp">홈</a>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="#">로그인</a>
						</li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="MemberInForm.do">회원가입</a>
						<ul class="submenu">
							<li><a href="MemberList.do" class="submenuLink">회원목록</a></li>
							<li><a href="MemberInForm.do" class="submenuLink">회원등록</a></li>
							<li><a href="#" class="submenuLink">회원수정</a></li>
							<li><a href="#" class="submenuLink">회원삭제</a></li>
						</ul></li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="BorderList.do">자유게시판</a></li>
					<li>|</li>
					<li class="topMenuLi"><a class="menuLink" href="#">로그아웃</a></li>
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>