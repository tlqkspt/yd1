package co.kdw.member.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.member.common.MCommand;
import co.kdw.member.command.MemberList;

/**
 * Servlet implementation class FrontController
 */

//////////////// 안씀
//@WebServlet(name = "MbFController", urlPatterns = { "/MbFController" })
//public class FrontController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private HashMap<String, MCommand> map = null;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FrontController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//		map = new HashMap<String, MCommand>();
//		map.put("/MemberList.do",new MemberList());	// 회원리스트
//	}
//	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		String uri = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String path = uri.substring(contextPath.length());
//		MCommand command = map.get(path);
//		command.excute(request, response);
//		
//	}
//
//}
