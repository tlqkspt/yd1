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
 * Servlet implementation class MemberEdit
 */
@WebServlet("/MemberEdit")
public class MemberEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEdit() {
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
		//여기기술
		JoinDao dao = new JoinDao();
		MemberDto dto = new MemberDto();
		String id = request.getParameter("id");
		dto = dao.serch(id);
		
		request.setAttribute("dto", dto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/memberedit.jsp");
		dispatcher.forward(request, response);
		
	}

}
