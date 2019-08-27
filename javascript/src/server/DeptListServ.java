package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class DeptListServ
 */
@WebServlet("/DeptListServ")
public class DeptListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DAO 에서 부서목록 조회
		ArrayList<Map<String,String>> list = new ArrayList<>();
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("departmentId","10");
		map.put("departmentName", "개발");
		list.add(map);
		
		map = new HashMap<>();
		map.put("departmentId","20");
		map.put("departmentName", "인사");
		list.add(map);		
		
		String json = JSONArray.fromObject(list).toString();
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print(json);
		
		
//////////////////////////////////////////////20190826
//		list.add(new Dept("10","개발"));
//		list.add(new Dept("20","인사"));
//		list.add(new Dept("30","기획"));
		
//		response.setContentType("text/html; charset=UTF-8");		//한글이포함된경우 반드ㅡ시넣어줘야 한글안깨진다
//		response.getWriter().print(JSONArray.toJSONString(list));	//자바객체 json으로
		//map으로하면 알아서바꿔줌
		///////////////////////////////////////////
		
	}
}
