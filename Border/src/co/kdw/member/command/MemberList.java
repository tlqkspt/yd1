package co.kdw.member.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.member.common.HttpUtil2;
import co.kdw.member.dao.MemberDao;
import co.kdw.member.dto.MemberDto;

public class MemberList implements Command {		//멤버리스트

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response){
		MemberDao dao = new MemberDao();
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		list = dao.memberlist();
		request.setAttribute("list", list);		//list받아옴
		String viewPage = "jsp/memberlist.jsp";
		HttpUtil2.forward(request, response, viewPage);
		
		
	}
	
}
