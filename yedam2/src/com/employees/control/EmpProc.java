package com.employees.control;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.employees.EmpService;
import com.employees.Employee;
import com.employees.impl.EmpServiceImpl;

public class EmpProc {
	Scanner sc = new Scanner(System.in);
	EmpServiceImpl service = EmpServiceImpl.getInstance();

	public void execute() {
		int menu = 0;

		// 로그인해야 사용할수있게
		// loginCheck();

		while (true) {
			System.out.println("메뉴실행.  1)단건조회  2)전체조회 3)입력 4)salary수정  5)삭제 9)종료");
			menu = sc.nextInt();
			if (menu == 1)
				getEmpProc();
			else if (menu == 2)
				getEmpListProc();
			else if (menu == 3)
				insertEmp();
			else if (menu == 4) {
				// 조회되면 수정
				updateEmp();
			}
			else if (menu == 5) {
				deleteEmp();
			}

			else if (menu == 9) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
	}

	// 로그인 체크.
	public void loginCheck() {
		Map<String, String> map = service.memberInfo();
		while (true) {
			System.out.println("아이디 입력:");
			String id = sc.nextLine();
			System.out.println("비밀번호 입력:");
			String pw = sc.nextLine();
			if (map.containsKey(id)) {
				if (map.get(id).equals(pw)) {
					System.out.println("로그인 되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("존재하지 않는 아이디 입니다.");
			}
		}
	}

//		public boolean login(map idpw) {
//		conn = DAO.getConnet();
//		String sql = "select id, password"+ 
//				     "from login_temp"+
//				     "where id ="+  id  +"and password =" + password ;
//				
//		
//	}
	
	
	// 삭제
	public void deleteEmp() {
		System.out.println("삭제할 empID입력:");
		int empId = sc.nextInt();
		Employee emp = service.getEmp(empId);
		System.out.println(emp);
		if(emp != null) {
			service.deleteEmp(empId);
		}else 
			System.out.println("없는사원입니다.");
			
		//System.out.println(emp);
	}

	// salary 수정
	public void updateEmp() {
		System.out.println("수정할 ID를 입력하세요:");
		int empId = sc.nextInt();
		Employee emp = service.getEmp(empId);
		System.out.println(emp);
		if (emp != null) {
			System.out.println("salary 얼마로 수정?:");
			int salary = sc.nextInt();
			sc.nextLine();
			emp.setSalary(salary);
			service.updateEmp(emp);

			System.out.println(emp);
		} else
			System.out.println("없는 사원임.");
		// service.updateEmp(service.getEmp(empId));

	}

	// 한건입력.
	public void insertEmp() {
		// EmpServiceImpl service = new EmpServiceImpl(); //EmpServiceImpl service =
		// EmpServiceImpl.getInstance(); 로 대체
		System.out.println("아이디를 입력:");
		int empId = sc.nextInt();
		sc.nextLine(); // sc.nextLine(); 안써주면 엔터키가 살아서 다음 입력에 먹힘 sc.nextInt();가 숫자만 먹기때문
		System.out.println("이름을 입력:");
		String firstName = sc.nextLine();
		System.out.println("성을 입력:");
		String lastName = sc.nextLine();
		System.out.println("Salary 입력:");
		int salary = sc.nextInt();
		sc.nextLine();
		System.out.println("Email 입력:");
		String email = sc.nextLine();
		System.out.println("job 입력:");
		String jobId = sc.nextLine();
		Employee emp = new Employee(empId, firstName, lastName, salary);
		emp.setEmail(email);
		emp.setJobId(jobId);
		service.insertEmp(emp);
	}

	// 단건조회.
	public void getEmpProc() {
		// EmpServiceImpl service = new EmpServiceImpl(); //EmpServiceImpl service =
		// EmpServiceImpl.getInstance(); 로 대체
		// EmpService service = new NewEmpServiceImpl();

		System.out.println("조회할 ID를 입력하세요.");
		int empId = sc.nextInt();
		Employee emp = service.getEmp(empId);
		System.out.println(emp);
	}

	// 전체조회.
	public void getEmpListProc() {
		// EmpService service = new EmpServiceImpl(); //EmpServiceImpl service =
		// EmpServiceImpl.getInstance(); 로 대체
		List<Employee> list = service.getEmpList();
		for (Employee emp : list) {
			System.out.println(emp);
		}
	}
}
