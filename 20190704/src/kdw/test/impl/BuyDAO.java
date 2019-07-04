package kdw.test.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void addCart(Product prod) {
		conn = DAO.getConnet();

		String sql = "insert into cart values(qtylist_num,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prod.getModel());
			pstmt.setInt(2, prod.getValues());

			pstmt.executeUpdate();

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
			prod.setModel(rs.getString("model"));
			prod.setName(rs.getString("model"));
			prod.setValues(rs.getInt("price"));

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return prod;
	}
}
