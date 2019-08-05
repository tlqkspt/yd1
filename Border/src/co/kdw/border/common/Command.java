package co.kdw.border.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;		//여기 예외처리하면 다른데서 안해줘도됨
	
}
