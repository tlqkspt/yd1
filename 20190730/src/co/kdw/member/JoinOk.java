package co.kdw.member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.member.dao.JoinDao;
import co.kdw.member.dto.MemberDto;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet(description = "회원가입을 처리하는 서블릿", urlPatterns = { "/JoinOk" })
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);	//변경
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) {	// 추가
		//여기다씀
	    JoinDao dao = new JoinDao();		//추가
	    MemberDto dto = new MemberDto();		//추가
	    
		try {
			request.setCharacterEncoding("utf-8");			//없으면 한글 깨진채로 들어감
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		dto.setMemberId(request.getParameter("id"));
		dto.setMemberPassword(request.getParameter("password"));
		dto.setMemberName(request.getParameter("name"));
		dto.setMemberBirth(request.getParameter("birth"));
		dto.setMemberAddr(request.getParameter("addr"));
		
		int n = dao.insert(dto);
		dao.close();		//
		
		if(n != 0) {
			try {
				response.sendRedirect("jsp/joinResult.jsp");	//등록성공패이지
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("jsp/joinFail.jsp");		//등록실패페이지
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);	//변경
	}

}
