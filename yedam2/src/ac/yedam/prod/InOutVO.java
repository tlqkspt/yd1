package ac.yedam.prod;

import java.time.LocalDateTime;

public class InOutVO {
	private String productCode;
	private int qty;	//수량
	private String issueDate;  //출입고 발생일

	public InOutVO() {
		
	}
	public InOutVO(String productCode, int qty, String issueDate) {
		super();
		this.productCode = productCode;
		this.qty = qty;
		this.issueDate = issueDate;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	
	@Override
	public String toString() {
		return "InOutVO [productCode=" + productCode + ", qty=" + qty + ", issueDate=" + issueDate + "]";
	}
	
	public void showInfo() {
		if(qty>0)
			System.out.printf("제품코드: %-5S | 제품수량: +%-5d | 날짜: %-5S\n",productCode,qty,issueDate);
		else
			System.out.printf("제품코드: %-5S | 제품수량: %-5d | 날짜: %-5S\n",productCode,qty,issueDate);
	}
	
}
