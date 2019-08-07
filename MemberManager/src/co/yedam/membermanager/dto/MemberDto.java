package co.yedam.membermanager.dto;

import java.sql.Date;

public class MemberDto {
	private String mId;
	private String mPass;
	private String mName;
	private String mAddr;
	private Date mDate;
	private String mGrant;		//자바 캐릭터타입은  1자  오라클db에선 1자아님
	
	public MemberDto() {
		
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPass() {
		return mPass;
	}

	public void setmPass(String mPass) {
		this.mPass = mPass;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmAddr() {
		return mAddr;
	}

	public void setmAddr(String mAddr) {
		this.mAddr = mAddr;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public String getmGrant() {
		return mGrant;
	}

	public void setmGrant(String mGrant) {
		this.mGrant = mGrant;
	}
	
	
}
