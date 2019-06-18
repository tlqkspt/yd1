package com.employees;

import java.util.List;
import java.util.Map;

public interface EmpService {
	//단건 조회(employee_id)
	public Employee getEmp(int empId);
	//전체 조회
	public List<Employee> getEmpList();
	// 입력
	public void insertEmp(Employee emp);
	// 수정
	public void updateEmp(Employee emp);
	//삭제
	public void deleteEmp(int empId);
	
	//로그인 체크 (추가)
	public Map<String, String> memberInfo();
	
}
