package co.kdw.border.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.kdw.border.common.Command;
import co.kdw.border.common.HttpUtil;

public class WriterComm implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String viewPage = "jsp/borderinsert.jsp";
		try {
			HttpUtil.forward(request, response, viewPage);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
