package ac.yedam.prod;

public class ProductVO {
	private String productCode;
	private String productName;
	private int productPrice;
	
	public ProductVO() {
		super();
	}

	public ProductVO(String productCode, String productName, int productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "[productCode=" + productCode +"\t"+ ", productName=" + productName +"\t"+ ", productPrice="
				+ productPrice + "]";
	}
	
	public void showInfo() {
		System.out.printf("제품코드: %-5S | 제품이름: %-15s | 가격: %-5d\n",productCode,productName,productPrice);
	}
	
}
