package co.kdw.border.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BorderContents.BorderContents;
import co.kdw.border.command.BorderInsert;
import co.kdw.border.command.BorderList;
import co.kdw.border.common.Command;

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
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Command command;
		String viewPage = null;		// serviceImpl 만들려고?	//돌려줘야할 페이지를 담는거
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String req = uri.substring(contextPath.length());	// 실제 요청한 *.do
		
		if(req.equals("/BorderList.do")) {
			command = new BorderList();		//service 인터페이스 통해서 BorderList 객체를 생성
			command.excute(request, response); //실행
			viewPage = "jsp/borderlist.jsp";
		} else if(req.equals("/BorderContents.do")) {
			command = new BorderContents();
			command.excute(request, response);
			viewPage = "jsp/bordercontents.jsp";
		} else if(req.contentEquals("/BorderInsert.do")) {
			command = new BorderInsert();		//작업해야함
			command.excute(request, response);
			viewPage = "jsp/borderinsert.jsp";
		}
			// else if(req.equals()) {
		
			//처리할 다른거 생기면 여기에 계속해서 추가한다
//		}   else if() ...
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	

}
