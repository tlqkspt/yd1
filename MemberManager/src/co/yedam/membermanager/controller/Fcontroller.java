package co.yedam.membermanager.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanager.command.BorderList;
import co.yedam.membermanager.command.Indexdo;
import co.yedam.membermanager.command.LogOut;
import co.yedam.membermanager.command.Login;
import co.yedam.membermanager.command.LoginForm;
import co.yedam.membermanager.common.Command;

/**
 * Servlet implementation class Fcontroller
 */
@WebServlet("/Fcontroller")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = null;
       
    public Fcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		map.put("/Index.do", new Indexdo());
		map.put("/LoginForm.do", new LoginForm());
		map.put("/Login.do", new Login());
		map.put("/LogOut.do", new LogOut());
		map.put("/BorderList.do", new BorderList());
		// command 추가
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		//글자 깨짐 방지
		String uri = request.getRequestURI();					
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());		//uri 에서 contextpath 뒤부터
		Command command = map.get(path);			//인터페이스 통해서 서비스 구현했음
		command.excute(request, response);
	}

}
