package com.employees.control;

import java.util.Scanner;

import com.employees.EmpService;
import com.employees.Employee;
import com.employees.impl.EmpServiceImpl;

public class EmpProc {
	Scanner sc = new Scanner(System.in);
	
	public void getEmpProc() {
		EmpServiceImpl service = new EmpServiceImpl();
		//EmpService service = new NewEmpServiceImpl();
		
		System.out.println("조회할 ID를 입력하세요.");
		int empId = sc.nextInt();
		Employee emp = service.getEmp(empId);
		System.out.println(emp);
	}
}
