package co.kdw.border.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BorderContents.BorderContents;
import co.kdw.border.command.BorderDelete;
import co.kdw.border.command.BorderEdit;
import co.kdw.border.command.BorderEditWrite;
import co.kdw.border.command.BorderInsert;
import co.kdw.border.command.BorderList;
import co.kdw.border.common.Command;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = null;    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

/////////////////////////////////////////////////////////////////////////////////////////////////
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
		} else if(req.equals("/BorderContents.do")) {	///게시글보기
			command = new BorderContents();
			command.excute(request, response);
			viewPage = "jsp/bordercontents.jsp";
		} else if(req.contentEquals("/Writer.do")) {		//글쓰기페이지이동
			viewPage = "jsp/borderinsert.jsp";
//		} else if(req.contentEquals("/TopMenu.do")) {		///???????????????????????????????
//			viewPage = "jsp/topmenu.jsp";
		} else if(req.contentEquals("/BorderInsert.do")) {	//글쓰기저장
			command = new BorderInsert();
			command.excute(request, response);
			viewPage = "/BorderList.do";
		} else if(req.contentEquals("/BorderEdit.do")) {
			command = new BorderEdit();			//글 수정
			command.excute(request, response);
			viewPage = "jsp/borderedit.jsp";
		} else if(req.contentEquals("/BorderDelete.do")) {
			command = new BorderDelete();	//글삭제
			command.excute(request, response);
			viewPage = "/BorderList.do";
		} else if(req.contentEquals("/BorderEditWrite.do")) {
			command = new BorderEditWrite();
			command.excute(request, response);
			viewPage = "/BorderContents.do";
		}
			// else if(req.equals()) {
		
			//처리할 다른거 생기면 여기에 계속해서 추가한다
//		}   else if(...) ...
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////

}
