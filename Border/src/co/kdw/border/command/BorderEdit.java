package co.kdw.border.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderEdit implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDao dao = new BorderDao();
		BorderDto dto = new BorderDto();
		
		int id = Integer.valueOf(request.getParameter("id"));
		dto = dao.editSerch(id);
		request.setAttribute("dto", dto);
		
	}

}
