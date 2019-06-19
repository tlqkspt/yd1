package ac.yedam.prod.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employees.common.DAO;

import ac.yedam.prod.ProductVO;

public class ProductDAO {
	// 필드선언
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 상품 조회
	public ProductVO getProd(String prodCode) {
		conn = DAO.getConnet();
		String sql = "select product_code, product_name, product_price " //일렬로 작성을 했을 때 FROM / WHERE / ORDER 앞에는 띄어쓰기가 되어 있어야 합니다.
			    	+"from yd_product "
				    +"where product_code=?";  //+"where product_code="+prodCode; 왜안됨?
		ProductVO prod = null;
		//System.out.println(prodCode);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodCode);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				prod = new ProductVO();
				prod.setProductCode(rs.getString("product_code"));
				prod.setProductName(rs.getString("product_name"));
				prod.setProductPrice(rs.getInt("product_price"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return prod;
	}
	
	// 상품 입력
	public void insertProd(ProductVO prod) {
		conn = DAO.getConnet();
		String sql = "insert into yd_product (product_code, product_name, product_price)"+
					"values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prod.getProductCode());
			pstmt.setString(2, prod.getProductName());
			pstmt.setInt(3, prod.getProductPrice());
			
			int r = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
	}
	
	//상품변경
	public void changeProd(ProductVO prod) {
		conn = DAO.getConnet();
		String sql = "update yd_product set product_name = ?, product_price = ? "+
		        	"where product_code = ?";
		try {
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, prod.getProductName());
			pstmt.setInt(2, prod.getProductPrice());
			pstmt.setString(3, prod.getProductCode());

			int r = pstmt.executeUpdate(); //업데이트커밋
		} catch (SQLException e) {				
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
	}
	
	//상품전체조회
	public List<ProductVO> getProdList(){
		conn = DAO.getConnet();
		String sql = "select product_code, product_name, product_price "+
					"from yd_product";
		ProductVO prod = null;
		List<ProductVO> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				prod = new ProductVO();
				prod.setProductCode(rs.getString("product_code"));
				prod.setProductName(rs.getString("product_name"));
				prod.setProductPrice(rs.getInt("product_price"));
				list.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
		return list;
	}
	
	////////////////////////////
	
	//입고처리
	
	//출고처리
	
	//전체재고
	
	
}
