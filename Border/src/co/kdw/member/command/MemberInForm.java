package co.kdw.member.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.member.common.HttpUtil2;

public class MemberInForm implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String viewPage="jsp/memberin.jsp";
		
		HttpUtil2.forward(request, response, viewPage);
	}

}
