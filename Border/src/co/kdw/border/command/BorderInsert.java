package co.kdw.border.command;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.kdw.border.common.Command;
import co.kdw.border.common.HttpUtil;
import co.kdw.border.dao.BorderDao;
import co.kdw.border.dto.BorderDto;

public class BorderInsert implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		BorderDto dto = new BorderDto();
		BorderDao dao = new BorderDao();
	
		String path = request.getSession().getServletContext().getRealPath("fileupload");	//실제 파일이 저장될 위치
		int size = 1024 * 1024 * 10;	//10M	파일사이즈 html프로토콜? 기본 200메가
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String str = (String)files.nextElement();
			
			String file = multi.getFilesystemName(str);		//저장됨
			String oriFile = multi.getOriginalFileName(str);	//파일명
			
			dto.setWriter(multi.getParameter("writer"));		//파일업로드때문에 멀티로 수정
			dto.setSubject(multi.getParameter("subject"));
			dto.setContents(multi.getParameter("contents"));
			dto.setUserId(multi.getParameter("sid"));
			System.out.println(multi.getParameter("sid")+"sid  ???");
			dto.setFileName(oriFile);
			int n = dao.insert(dto);
			request.setAttribute("n", n);
			String viewPage = "/BorderList.do";
			try {
				HttpUtil.forward(request, response, viewPage);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		dto.setWriter(request.getParameter("writer"));		//파일업로드때문에 멀티로 수정
//		dto.setSubject(request.getParameter("subject"));
//		dto.setContents(request.getParameter("contents"));
//		int n = dao.insert(dto);
//		request.setAttribute("n", n);		//입력성공실패체크
	}
}