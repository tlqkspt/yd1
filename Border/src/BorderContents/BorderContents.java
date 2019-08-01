package BorderContents;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderContents implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.valueOf(request.getParameter("id"));
		BorderDao dao = new BorderDao();
		BorderDto dto = new BorderDto();
		dto = dao.serch(id);
		request.setAttribute("dto", dto);
		
	}

}
