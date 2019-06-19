package com.employees.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employees.Employee;
import com.employees.common.DAO;

public class EmpDAO {
	//필요한 필드 선언.
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 한명 삭제
		public void deleteEmp(int empId) {
			conn = DAO.getConnet();
			String sql = "delete from emp_temp where employee_id =" + empId;
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			//	System.out.println("삭제됨"); EmpProc 에 넣을것
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
	
	// 한명 연봉 수정
		public void updateEmp(Employee emp) {
			conn = DAO.getConnet();
			String sql = "update emp_temp set salary =?"+
					"where employee_id=?";

			//System.out.println(emp.getEmployeeId()+","+emp.getSalary());
			
			try {
				pstmt = conn.prepareStatement(sql);	
				pstmt.setInt(1, emp.getSalary());
				pstmt.setInt(2, emp.getEmployeeId());

				int r = pstmt.executeUpdate(); //tttttttttqqqqq 업데이트커밋
			} catch (SQLException e) {				
				e.printStackTrace();
			}finally {
				DAO.close(conn);
			}
		}
	
	
	
	public Map<String,String> memberInfo(){		//조회전 login_temp 아이디인지 검사위해
		conn = DAO.getConnet();
		String sql = "select id, password from login_temp";
		String id, pw;
		Map<String, String> map =new HashMap<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
				pw = rs.getString("password");
				map.put(id, pw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return map;
	}
	
	//한건입력.
	public void insertEmp(Employee emp) {
		conn = DAO.getConnet();
		String sql = "insert into emp_temp (employee_id, first_name, last_name, email, salary, job_id, hire_date) " + 
				"values (?, ?, ?, ?, ?, ?, sysdate)"; // ? 외부에서 값을 받아넣음
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getEmail());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setString(6, emp.getJobId());
			
			int r = pstmt.executeUpdate();
			System.out.println(r+" 건이 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
	}
	
	//전체 사원 조회.
	public List<Employee> getEmpList(){
		conn = DAO.getConnet();
		String sql = "select employee_id, first_name, last_name, salary, email, job_id from emp_temp ";
		Employee emp = null;
		List<Employee> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
		
		return list;
		
	}
	
	//사원번호로 단건 조회.
	public Employee getEmp(int empId) {
		conn = DAO.getConnet();
		String sql = "select employee_id, first_name, last_name, salary, email, job_id from emp_temp "
				+ "where employee_id="+empId;
		Employee emp = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id")); //101
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return emp;
	}
	
//	//로그인계정 확인
//	public boolean login(map idpw) {
//		conn = DAO.getConnet();
//		String sql = "select id, password"+ 
//				     "from login_temp"+
//				     "where id ="+  id  +"and password =" + password ;
//				
//		
//	}
}
