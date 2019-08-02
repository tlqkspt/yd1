package co.kdw.border.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderInsert implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDto dto = new BorderDto();
		BorderDao dao = new BorderDao();
		
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContents(request.getParameter("contents"));
		int n = dao.insert(dto);
		request.setAttribute("n", n);		//입력성공실패체크
	}

}
