package co.kdw.border.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.common.HttpUtil;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderList implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDao dao = new BorderDao();
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		list = dao.select();
		request.setAttribute("list", list);
		String viewPage = "jsp/borderlist.jsp";
		try {
			HttpUtil.forward(request, response, viewPage);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
