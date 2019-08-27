package server;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class EmailCheck
 */
@WebServlet("/EmailCheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmailCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//email 파라미터를 받아서
		String email = request.getParameter("email");
		
		//DAO이용
		HashMap<String, String> map = new HashMap<>();
		if(email.equals("a@a.a")) {			// http://localhost/javascript/EmailCheck?email=a@a.a 이면 true 아니면 false
			map.put("result","true");
		} else {
			map.put("result","false");
		}
		
		//결과 json형식으로 변환해서 출력
		response.getWriter().print(JSONObject.fromObject(map));	//JSONObject.fromObject(map) 하나를?  List는 JSONArray
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
