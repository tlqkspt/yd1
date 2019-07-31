package co.kdw.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doController(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doController(request,response);
	}

	public void doController(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//컨트롤러 만들어줌
		request.setCharacterEncoding("utf-8");		//한글깨짐방지
		
		String viewPage = null; //path 돌려줄 페이지 경로를 지정하는 변수
	//	BCommand command = null;	//인터페이스 객체
		
		String uri = request.getRequestURI();	//uri를 얻음
		String conPath = request.getContextPath();	//컨텍스트 패스 얻음
		String com = uri.substring(conPath.length());	//컨텍스트 길이만큼 잘라내고 읽음
		
		if(com.equals("/memberEdit.do")) {	//form action 속성에 정의한 이름 ////사용자 맘대로 지정
			//이부분에 실제 처리할 서블릿 명령을 기술한다.

				//이런식으로 하면 너무길어진다	MAP<K,V> 사용해서 한줄로줄인다?
//			JoinDao dao = new JoinDao();				
//			MemberDto dto = new MemberDto();			
//			String id = request.getParameter("id");		
//			dto = dao.serch(id);						
//			request.setAttribute("dto", dto);

			//보내야할 페이지를 기술한다.
			//viewPage = "jsp/memberEditOk.jsp"
			
		} else if(com.equals("/memberinsert.do")) {	//호출할때 이런 이름으로 호출하면 된다
			//이부분에 실제 처리할 서블릿 명령을 기술한다.
			//보내야할 페이지를 기술한다.
			//viewPage = "jsp/memberEditOk.jsp"
		} else if(com.equals("/memberList.do")) {
			//이부분에 실제 처리할 서블릿 명령을 기술한다.
			//보내야할 페이지를 기술한다.
			//viewPage = "jsp/memberEditOk.jsp"
		}
	//	} else if(com.equals("insert.jsp")) //!!!! 이렇게하면 .do안타고 바로감
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
