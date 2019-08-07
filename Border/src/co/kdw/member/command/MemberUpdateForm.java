package co.kdw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.member.common.HttpUtil2;
import co.kdw.member.dao.MemberDao;
import co.kdw.member.dto.MemberDto;

public class MemberUpdateForm implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");		// 오류 getAttribute 써서 안나왔음
		System.out.println(id);
		MemberDto dto = new MemberDto();
		MemberDao dao = new MemberDao();
		dto = dao.memberSerch(id);
		
		request.setAttribute("dto", dto);
		
		String viewPage = "jsp/memberupdate.jsp";
		
		HttpUtil2.forward(request, response, viewPage);
	}

}
