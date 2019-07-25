<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm1" action="send.jsp" method="post">
	     아이디 : <input type="text" name="id" size=30><p>
	     이  름 : <input type="text" name="name" size=30><p>
	     주  소 : <input type="text" name="addr" size=100><p>
	     전화번호: <input type="text" name="tel" size=30><p>
	     취  미 : <input type="checkbox" name="hobby" value="등산">등산&nbsp;&nbsp;
	    	    <input type="checkbox" name="hobby" value="바둑">바둑&nbsp;&nbsp;
	    	    <input type="checkbox" name="hobby" value="골프">골프&nbsp;&nbsp;
	    	    <input type="checkbox" name="hobby" value="낚시">낚시&nbsp;&nbsp;
	    	    <input type="checkbox" name="hobby" value="당구">당구&nbsp;&nbsp;
	    	    <input type="checkbox" name="hobby" value="탁구">탁구&nbsp;&nbsp; <p>  
	     성  별:<input type="radio" name="gender" value="남" checked>남&nbsp;&nbsp;
	          <input type="radio" name="gender" value="여">여&nbsp;&nbsp; <p>
	          
	     전  공:<select name="major">
	              <option value="컴퓨터공학" >컴퓨터공학</option>
	              <option value="전자공학" selected="selected">전자공학</option>
	              <option value="의공학">의공학</option>
	              <option value="산업공학">산업공학</option>
	              <option value="경영공학">경영공학</option>
	          </select> <p>     
	      
	    <input type="submit" value="전송"> &nbsp;&nbsp;&nbsp;
	    <input type="reset" value="초기화">  
	</form>
</body>
</html>