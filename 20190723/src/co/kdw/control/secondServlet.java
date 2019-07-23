package co.kdw.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("/Second")
@WebServlet(urlPatterns =  "/Second", initParams = {@WebInitParam(name="id", value="abcde1"),@WebInitParam(name="pw",value="12345")})  //url mapping anotation (이ㅇ거없을땐 404에러 발생했다)
//@WebServlet(urlPatterns =  "/Second", initParams = {@WebInitParam(name="id", value="abcde"),@WebInitParam(name="pw",value="12345")})  url초기화??
public class secondServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("post방식으로 호출");
		doGet(req, res);  //doGet() 호출
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=UTF-8");  // 글자깨지는거 방지위해 캐릭터셋 정의해줌
		PrintWriter out = res.getWriter();
		
//		String id = req.getParameter("id");   //request 객체에 담긴 값을 읽어옴
//		String pw = req.getParameter("pw");           // 이거랑 위에줄 = 리퀘스트에서 가져오란거
		
//		String id = getInitParameter("id");   //초기 패라매트 값을 web.xml에서 가져옴
//		String pw = getInitParameter("pw");
		
		String id = getInitParameter("id");   //초기 패라매트 값을 어노테이션에서 가져옴
		String pw = getInitParameter("pw");
		
		String userName = getServletContext().getInitParameter("userName");  //web.xml context-param 을 가져옴
		String userId = getServletContext().getInitParameter("userId");
		
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>아이디 : " + id +"</br>");
		
		out.print("패스워드 : "+ pw +"<p></h1>");
		out.println("공통유저명 : " + userName);
		out.println("공통유저아이디: "+ userId);
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
