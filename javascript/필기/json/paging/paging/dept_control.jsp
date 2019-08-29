<%@page import="common.Paging"%>
<%@page import="ch08.DeptSearchVO"%>
<%@page import="ch08.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="deptVO" class="ch08.DeptVO"/>    
<jsp:setProperty property="*" name="deptVO"/>
<%
//dept_control.jsp
String action = request.getParameter("action");
DeptDAO dao = new DeptDAO();
if(action == null) {
	out.print("action null");
} else if( action.equals("list")) {
	//페이징처리
	String p = request.getParameter("p");
	int pageNum = 1;
	if(p != null && ! p.equals("")) {
		pageNum = Integer.parseInt(p);
	}
	//start, end
	//int page_unit = 10;
	//int s = (pageNum-1) * page_unit + 1;
	//int e = s + page_unit - 1;
	
	//searchVO에 담기
	DeptSearchVO searchVO = new DeptSearchVO();
	searchVO.setStart(paging.getFirst());
	searchVO.setEnd(paging.getLast());
	//searchVO.setLocation_id(request.getParameter("location_id"));
	//searchVO.setManager_id(request.getParameter("manager_id"));
	//부서목록 data 조회
	//request.setAttribute("deptList", dao.getDeptList(searchVO));
	
	//paging 정보 저장
	Paging paging = new Paging();
	paging.setTotalRecord(dao.count(searchVO));
	paging.setPage(pageNum);
	//paging.setPageUnit(page_unit);  //한페이지 출력할 레코드 건수
	//paging.setPageSize(3);          //페이지번호 수 3인경우 (이전 1 2 3 다음) 
	//request.setAttribute("paging",paging);
			
	pageContext.forward("deptList.jsp");
	
} else if( action.equals("insert")) {
	
	dao.deptInsert(deptVO);
	response.sendRedirect("dept_control.jsp?action=list");
	
} else {
	out.print("no action");
}
%>

