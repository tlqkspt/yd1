package co.kdw.border.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.dao.BorderDao;

public class BorderDelete implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BorderDao dao = new BorderDao();
		int id = Integer.valueOf(request.getParameter("id"));
		dao.delete(id);
		request.setAttribute("id", id);
	}

}
