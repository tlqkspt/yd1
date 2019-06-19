package ac.yedam.prod.impl;

import java.util.List;

import ac.yedam.prod.ProductService;
import ac.yedam.prod.ProductVO;

public class ProductServiceImpl implements ProductService {
		private static ProductServiceImpl singleton = new ProductServiceImpl();		//싱글톤
		private ProductServiceImpl() {}
		public static ProductServiceImpl getInstance() {
			return singleton;
		}
		ProductDAO dao = new ProductDAO();
		
		@Override
		public ProductVO getProd(String prodCode) {
			// TODO Auto-generated method stub
			return dao.getProd(prodCode);
		}
		@Override
		public void insertProd(ProductVO prod) {
			// TODO Auto-generated method stub
			dao.insertProd(prod);
		}
		@Override
		public void changeProd(ProductVO prod) {
			// TODO Auto-generated method stub
			dao.changeProd(prod);
		}
		@Override
		public List<ProductVO> getProdList() {
			// TODO Auto-generated method stub
			return dao.getProdList();
		}
}
