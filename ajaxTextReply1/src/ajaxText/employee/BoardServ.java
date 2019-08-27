package ajaxText.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class BoardServ
 */
@WebServlet("/BoardServ")
public class BoardServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServ() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		BoardDAO dao = new BoardDAO();
		
		if(action == null || action.equals(" ")) {
			System.out.println("invalid action");
			out.print("invalid action");
			
		} else if (action.equals("list")) {
			List<BoardDTO> list = dao.getBoardList();
			out.print(JSONArray.fromObject(list).toString());
		} else if (action.equals("register")) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//새로운 글 작성시 신규 게시글 번호.
			int newBno = dao.getNewBoard();
			BoardDTO board = new BoardDTO();
			board.setBoardNo(newBno);
			board.setTitle(title);
			board.setContent(content);
			
			if(dao.insertBoard(board)>0) {	//이번호를 다른데 쓸거임
				out.print(newBno);
			};
		}// end of if.. else..
		else if (action.equals("get")) {
			int bno = Integer.parseInt(request.getParameter("boardNo"));
			out.print(JSONArray.fromObject(dao.getBoard(bno)).toString());
		} else if (action.equals("update")) {
			int id = Integer.parseInt(request.getParameter("boardNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardDTO dto = new BoardDTO();
			dto.setBoardNo(id);
			dto.setTitle(title);
			dto.setContent(content);
			
			dao.updateBoard(dto);
		}else if(action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("boardNo"));
			dao.deleteBoard(id);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
