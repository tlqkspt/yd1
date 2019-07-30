package co.kdw.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.kdw.member.dao.JoinDao;

@WebServlet("/IdChk")   // 빼먹으면 경로못찾아서 404에러뜸
public class IdChk extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public IdChk() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(request, response);
	}

	public void doAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		JoinDao dao = new JoinDao();
		String id = request.getParameter("id"); //폼에서넘어오는이름
		String rId = dao.select(id);			//DB에서 오는 id값 담기
		dao.close();
		
		//////////////////////////////////// 반드시 기억***************************************************************
		
		request.setAttribute("rid", rId);	//돌려줄 객체 및 데이터 값을 실어준다.  db에서가져온 id
		request.setAttribute("oldid", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/idChk.jsp");  //요청을 실어서 저놈한테가라		//보여줄페이지
		dispatcher.forward(request, response);		//보여줄페이지이동
		/////////////////////////////////////
		
	}
	
	

}
