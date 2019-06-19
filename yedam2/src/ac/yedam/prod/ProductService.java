package ac.yedam.prod;

import java.util.List;

public interface ProductService {
	//상품조회
	public ProductVO getProd(String prodCode);
	//상품등록
	public void insertProd(ProductVO prod);
	//상품변경
	public void changeProd(ProductVO prod);
	//전체상품
	public List<ProductVO> getProdList();
	
	
}
