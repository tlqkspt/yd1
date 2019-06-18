package com.employees.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employees.Employee;
import com.employees.common.DAO;

public class EmpDAO {
	//필요한 필드 선언.
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
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
}
