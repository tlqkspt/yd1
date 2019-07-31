package co.kdw.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.member.dao.JoinDao;
import co.kdw.member.dto.MemberDto;

/**
 * Servlet implementation class MemberUpdate
 */
@WebServlet("/MemberUpdate")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JoinDao dao = new JoinDao();
		MemberDto dto = new MemberDto();
		request.setCharacterEncoding("utf-8");
		int n = 0;
		dto.setMemberId(request.getParameter("id"));		//memberedit.jsp 에서온값
		dto.setMemberPassword(request.getParameter("password"));
		dto.setMemberName(request.getParameter("name"));
		dto.setMemberAddr(request.getParameter("addr"));
		dto.setMemberBirth(request.getParameter("birth"));
		
		n = dao.update(dto);
		
		request.setAttribute("n", n);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/updateOk.jsp");
		dispatcher.forward(request, response);
		
	}

}
