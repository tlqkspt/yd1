package co.kdw.mainClass;

import co.kdw.DriverLicense.DriverLicenseInfo;
import co.kdw.DriverLicense.DriverLicenseInfoList;

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
		System.out.println();
		System.out.println();
		
		DriverLicenseInfoList dLL = new DriverLicenseInfoList();
		
		dLL.dLList[0] = dL;
		
		dLL.dLList[0].showInfo();
		System.out.println();
		
		dL.dLList[0] = new DriverLicenseInfo();
		dL.dLList[0].setdId("1111111");
		dL.dLList[0].setdName("1동");
		dL.dLList[0].setdAddr("1구");
		dL.dLList[0].setdType("1종보통");
		dL.dLList[0].setdDate("2018-03-02");
		dL.dLList[0].setdExDate("2026-03-02");
		dL.dLList[0].showInfo();
	}
}
