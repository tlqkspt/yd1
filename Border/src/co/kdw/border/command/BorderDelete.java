package co.kdw.border.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.common.HttpUtil;
import co.kdw.border.dao.BorderDao;

public class BorderDelete implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BorderDao dao = new BorderDao();
		int id = Integer.valueOf(request.getParameter("id"));
		dao.delete(id);
		request.setAttribute("id", id);
		String viewPage = "/BorderList.do";
		try {
			HttpUtil.forward(request, response, viewPage);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
