package ajaxText.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BoardDAO dao = new BoardDAO();
		List<Employee> list = dao.getEmpList();
		JSONArray ary = new JSONArray();	//jason simple 1.1.1
		JSONArray orig = new JSONArray();	//외부에서감싸는 배열? 배열에 담겨진값을 다시 배열에
		JSONObject obj = new JSONObject();	
		for(Employee emp : list) {
			ary = new JSONArray();	//할때마다 새로 만들어야함
			ary.add(emp.getFirstName());
			ary.add(emp.getLastName());
			ary.add(emp.getJobId());
			ary.add(emp.getEmail());
			ary.add(emp.getHireDate());
			ary.add(emp.getSalary());
			orig.add(ary);
		}
		obj.put("data", orig);
		response.getWriter().print(obj);
//		PrintWriter out = response.getWriter(); 이거 두줄이랑 위에꺼랑 같다
//		out.print(obj);							
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
