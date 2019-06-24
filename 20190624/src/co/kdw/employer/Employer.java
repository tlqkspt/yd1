package co.kdw.employer;

public class Employer extends Salary {
	
	private int gubun;
	private String emp;
	private String eId;
	private String sName;
	private String eDate;
	private String position;
	
	public Employer() {
		// TODO Auto-generated constructor stub
	}
	
	public Employer(int gu, String id, String name, String da, String po) {
		this.gubun = gu;
		this.eId = id;
		this.sName = name;
		this.eDate = da;
		this.position = po;
	}
	
	private void insert() {
		if(gubun != 0) 
			emp = "정규직";
		else
			emp = "계약직";
	}
	

	public String toString() {
		System.out.println(emp + " " + eId + " "+ sName + " "+ eDate+" "+position+" "+ sal());
		return null;
	}
	
	@Override
	public int sal() {
		// TODO Auto-generated method stub
		int money;
		if(gubun !=0)
			money = gibon + sudang;
		else
			money = gibon;
		return money;
	}
	
	public void run() { //캡슐화 완전한건아님
		insert();
		toString();
	}

	public int getGubun() {
		return gubun;
	}

	public void setGubun(int gubun) {
		this.gubun = gubun;
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
