package co.yedam.membermanager.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanager.common.Command;
import co.yedam.membermanager.common.HttpRes;
import co.yedam.membermanager.dao.BorderDao;
import co.yedam.membermanager.dto.BorderDto;

public class BorderList implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BorderDao dao = new BorderDao();
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		list = dao.select();
		request.setAttribute("list", list);
		String viewPage = "jsp/borderlist.jsp";
		
		HttpRes.forword(request, response, viewPage);
	
	}

}
