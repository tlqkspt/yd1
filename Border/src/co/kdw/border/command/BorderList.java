package co.kdw.border.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderList implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDao dao = new BorderDao();
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		list = dao.select();
		request.setAttribute("list", list);
	}

}
