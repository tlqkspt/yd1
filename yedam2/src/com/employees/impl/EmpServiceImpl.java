package com.employees.impl;

import java.util.List;
import java.util.Map;

import com.employees.EmpService;
import com.employees.Employee;

public class EmpServiceImpl implements EmpService {
	private static EmpServiceImpl singleton = new EmpServiceImpl();		//싱글톤
	private EmpServiceImpl() {}
	public static EmpServiceImpl getInstance() {
		return singleton;
	}
	
	EmpDAO dao = new EmpDAO();
	
	
	@Override
	public Employee getEmp(int empId) {
		// TODO Auto-generated method stub
		return dao.getEmp(empId);
	}

	@Override
	public List<Employee> getEmpList() {
		// TODO Auto-generated method stub
		return dao.getEmpList();
	}

	@Override
	public void insertEmp(Employee emp) {
		// TODO Auto-generated method stub
		dao.insertEmp(emp);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		dao.updateEmp(emp);
		
	}

	@Override
	public void deleteEmp(int empId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Map<String, String> memberInfo() {
		// TODO Auto-generated method stub
		return dao.memberInfo();
	}

}
