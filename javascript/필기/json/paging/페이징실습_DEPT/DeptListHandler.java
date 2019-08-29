package dept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandHandler;
/**
 * 
 * @author User
 * 부서목록 조회 핸들러
 */
public class DeptListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//부서목록 조회
		//request.setAttribute("deptList", DeptDAO.getInstance().selectAll());
		//페이징 처리
		String p = request.getParameter("p");   //페이지번호
		int pageNo = 1;
		if( p != null && ! p.isEmpty()) {
			pageNo = Integer.parseInt(p);
		}
		int first, last;        // 조회할 시작과 끝 레코드 번호
		int recordTotal;        // 총레코드 갯수(DB조회)
		int pagePerRecord = 5;  // 한페이지에 출력할 레코드 건수
		int pageCnt;            // 페이지수
		first = (pageNo-1) * pagePerRecord + 1;          //해당페이지의 시작레코드 
		last = first + pagePerRecord - 1;                //해당페이지의 마지막레코드
		recordTotal = DeptDAO.getInstance().count();     //전체레코드 수
		pageCnt =  recordTotal/pagePerRecord 
				 + (recordTotal%pagePerRecord>0 ? 1 : 0);//마지막페이지번호 
				
		request.setAttribute("deptList", 
				          DeptDAO.getInstance().selectPage(first,last));
		request.setAttribute("pageCnt",pageCnt);
		//뷰페이지로 포워드
		return "deptList.jsp";
	}

}
