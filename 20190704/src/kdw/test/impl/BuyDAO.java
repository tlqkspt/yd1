package kdw.test.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kdw.test.BuyProd.Buy;
import kdw.test.common.DAO;
import kdw.test.prod.Product;

public class BuyDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<Product> prodList() {
		conn = DAO.getConnet();
		String sql = "select * from prod_list";
		Product prod = null;

		List<Product> prodList = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				prod = new Product();
				prod.setModel(rs.getString("model"));
				prod.setName(rs.getString("name"));
				prod.setValues(rs.getInt("price"));
				prodList.add(prod);
				// System.out.println(prod.getName());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return prodList;
	}

	// 장바구니
	public void addCart(List<Product> prodlist) {
		for (Product prod : prodlist) {
			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getName() + "  ");
			System.out.println(prod.getValues());
		}

//		conn = DAO.getConnet();
//		int n = 0;
//
//		String sql1 = "select MAX(order_no) from cart";
//		String strMax = null;
//		try {
//			pstmt = conn.prepareStatement(sql1);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) { // 최대값 저장
//				strMax = rs.getString("MAX(order_no)");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String sql = "insert into cart values(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// System.out.println(strMax);

			for (Product prod : prodlist) {
				pstmt.setString(1, prod.getModel());
				pstmt.setInt(2, prod.getQty());
				pstmt.setInt(3, (prod.getValues() * prod.getQty()));

				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}

	}

	// 일치모델 하나가져옴
	public Product getInfo(String model) {
		conn = DAO.getConnet();

		String sql = "select * from prod_list where model = ?";
		Product prod = null;
		try {
			prod = new Product();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, model);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				prod.setModel(rs.getString("model"));
				prod.setName(rs.getString("model"));
				prod.setValues(rs.getInt("price"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return prod;
	}

	// 카트리스트 출력
	public List<Product> getCartList() {
		conn = DAO.getConnet();

		String sql = "select * from cart";
		Product prod = null;
		List<Product> cartList = new ArrayList<Product>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				prod = new Product();
				prod.setModel(rs.getString("prod_code"));
				prod.setQty(rs.getInt("qty"));
				prod.setValues(rs.getInt("price"));
				cartList.add(prod);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cartList;
	}

	// 카트삭제
	public void delCart() {
		conn = DAO.getConnet();

		String sql = "delete from cart";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 주문테이블
	public Buy orderSet(List<Product> orderlist) {
		int orderNo = 0;
		int sumPrice = 0;
		Buy buy = null;

		for (Product prod : orderlist) {
			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getQty() + "  ");
			System.out.println(prod.getValues());
		}

		conn = DAO.getConnet();
		int n = 0;

		String sql1 = "select MAX(order_no) from order_list";
		String strMax = null;
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();

			while (rs.next()) { // 최대값 저장
				strMax = rs.getString("MAX(order_no)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "insert into order_list values(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			// System.out.println(strMax);

			for (Product prod : orderlist) {
				if (strMax == null) {
					pstmt.setInt(1, 1);
				} else {
					orderNo = Integer.parseInt(strMax) +1;
					pstmt.setInt(1, orderNo);
				}
				sumPrice += (prod.getValues() * prod.getQty());
		//		System.out.println(sumPrice+","+orderNo);
				pstmt.setString(2, prod.getModel());
				pstmt.setInt(3, prod.getQty());
				pstmt.setInt(4, sumPrice);
				pstmt.executeUpdate();
				
				buy = new Buy(orderNo, sumPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}return buy;

	}
}
