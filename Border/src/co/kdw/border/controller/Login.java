package co.kdw.border.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.kdw.border.common.Command;
import co.kdw.member.common.HttpUtil2;
import co.kdw.member.dao.MemberDao;
import co.kdw.member.dto.MemberDto;

public class Login implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		dto = dao.select(id,pw);
		HttpSession session = request.getSession(true);	//새션생성
		session.setAttribute("name", dto.getName());
		session.setAttribute("sid", dto.getId());
		
		String viewPage = "jsp/loginok.jsp";
		HttpUtil2.forward(request, response, viewPage);
	}

}
