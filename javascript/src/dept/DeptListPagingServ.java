package dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptListPagingServ
 */
@WebServlet("/DeptListPagingServ")
public class DeptListPagingServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeptListPagingServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이지 번호 파라미터 읽어옴
		String p = request.getParameter("p");
		int pageNum = 1;
		if(p != null && ! p.equals("")) {
			pageNum = Integer.parseInt(p);
		}
		
		DeptDto dept = new DeptDto();
		dept.setLocationId(request.getParameter("locationId"));
		dept.setManagerId(request.getParameter("managerId"));
		//paging 정보 저장
		Paging paging = new Paging();
		paging.setPageUnit(3);	//한페이지 출력할 레코드수
		paging.setTotalRecord(DeptDAO.getInstance().count(dept));
		paging.setPage(pageNum);
		
		//부서목록
		dept.setStart(paging.getFirst());
		dept.setEnd(paging.getLast());
		request.setAttribute("list", DeptDAO.getInstance().getDeptList(dept));
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("deptList.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
