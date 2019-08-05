package co.kdw.border.controller;

import java.io.IOException;
import java.util.HashMap;

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
import co.kdw.border.command.WriterComm;
import co.kdw.border.common.Command;
import co.kdw.member.command.MemberIn;
import co.kdw.member.command.MemberInForm;
import co.kdw.member.command.MemberList;
import co.kdw.member.command.MemberUpdate;
import co.kdw.member.command.MemberUpdateForm;

/**
 * Servlet implementation class FController
 */
@WebServlet("/FController")
public class FController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = null;    
	
    public FController() {		
        super();											
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
    	map.put("/BorderList.do", new BorderList());
    	map.put("/BorderContents.do", new BorderContents());
    	map.put("/Writer.do", new WriterComm()); 	//command 만들어야함
    	map.put("/BorderInsert.do", new BorderInsert());
    	map.put("/BorderEdit.do", new BorderEdit());
    	map.put("/BorderDelete.do", new BorderDelete());
    	map.put("/BorderEditWrite.do", new BorderEditWrite());
    	map.put("/MemberList.do",new MemberList());	// 회원리스트
    	map.put("/MemberIn.do", new MemberIn());// 회원가입
    	map.put("/MemberInForm.do", new MemberInForm());//회원가입페이지
    	map.put("/MemberUpdate.do", new MemberUpdate());//회원정보수정
    	map.put("/MemberUpdateForm.do", new MemberUpdateForm()); //회원정보수정페이지
    	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		Command command = map.get(path);
		command.excute(request, response);
	}
}
