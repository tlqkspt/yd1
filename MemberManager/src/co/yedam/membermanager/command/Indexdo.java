package co.yedam.membermanager.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanager.common.Command;
import co.yedam.membermanager.common.HttpRes;

public class Indexdo implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPage = "jsp/main.jsp";
		HttpRes.forword(request, response, viewPage);
	}

}
