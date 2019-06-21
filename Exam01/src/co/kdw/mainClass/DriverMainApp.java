package co.kdw.mainClass;

import co.kdw.DriverLicense.DriverLicenseInfo;

public class DriverMainApp {
	public static void main(String[] args) {
		DriverLicenseInfo dL = new DriverLicenseInfo();
		dL.setdId("1111111");
		dL.setdName("김길동");
		dL.setdAddr("대구");
		dL.setdType("1종보통");
		dL.setdDate("2018-03-02");
		dL.setdExDate("2026-03-02");
		dL.showInfo();
		
		System.out.println("=======================");
		
		DriverLicenseInfo dL2 = new DriverLicenseInfo("22222222","김운전","부산","2종보통","2019-04-05","2026-04-05");
		dL2.showInfo();
		
		
		
		System.out.println(dL2.getdType());
		
		
	}
}
