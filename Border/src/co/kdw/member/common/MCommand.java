package co.kdw.member.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MCommand {
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
