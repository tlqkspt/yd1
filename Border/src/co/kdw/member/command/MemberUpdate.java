package co.kdw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.member.common.HttpUtil2;
import co.kdw.member.dao.MemberDao;
import co.kdw.member.dto.MemberDto;

public class MemberUpdate implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pw = request.getParameter("password");
		String addr = request.getParameter("addr");
		
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		dto.setName(name);
		dto.setPw(pw);
		dto.setAddr(addr);
		
		int n = dao.memberUpdate(dto);
		
		request.setAttribute("n", n);
		
		String viewPage = "/MemberList.do";
		HttpUtil2.forward(request, response, viewPage);
	}

}
