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
import co.kdw.member.common.Paging;

public class BorderList implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDao dao = new BorderDao();
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		list = dao.select();
		//<li><a href="/mysite/board?page=${ i }">${ i }</a></li>// 링크를 어떻게 거나? hidden?
		Paging paging = new Paging();
		Integer blockStartNum = paging.getBlockStartNum();
		Integer blockLastNum = paging.getBlockLastNum();
		Integer lastPageNum = paging.getLastPageNum();
		int curPage = 1;
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);	//페이징 20190814
		
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
