package co.yedam.membermanager.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.membermanager.common.Command;
import co.yedam.membermanager.common.HttpRes;
import co.yedam.membermanager.dao.MemberDao;
import co.yedam.membermanager.dto.MemberDto;

public class Login implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession(true);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		dto = dao.login(id, pw);
	
		if(dto != null) {
			session.setAttribute("sid", dto.getmId());
			session.setAttribute("sname", dto.getmName());
			session.setAttribute("sgrant", dto.getmGrant());
		}
		
		String viewPage = "jsp/loginok.jsp";
		
		HttpRes.forword(request, response, viewPage);
	}

}
