package com.employees.impl;

import java.util.List;

import com.employees.EmpService;
import com.employees.Employee;

public class EmpServiceImpl implements EmpService {
	EmpDAO dao = new EmpDAO();
	
	@Override
	public Employee getEmp(int empId) {
		// TODO Auto-generated method stub
		return dao.getEmp(empId);
	}

	@Override
	public List<Employee> getEmpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEmp(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmp(int empId) {
		// TODO Auto-generated method stub
		
	}

}
