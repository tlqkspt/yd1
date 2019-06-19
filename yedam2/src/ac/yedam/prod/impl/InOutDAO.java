package ac.yedam.prod.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employees.common.DAO;

import ac.yedam.prod.InOutVO;
import ac.yedam.prod.ProductVO;

public class InOutDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 입고처리
	public void inService(InOutVO prodIO) {
		conn = DAO.getConnet();
		String sql = "insert into yd_prod_txn (product_code, txn_qty, receipt_issue_date )" + "values(?, ?, sysdate )";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodIO.getProductCode());
			pstmt.setInt(2, prodIO.getQty());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}

	}

	// 출고처리
	public void outService(InOutVO prodIO) {
		conn = DAO.getConnet();
		String sql = "insert into yd_prod_txn (product_code, txn_qty, receipt_issue_date)" + "values(?, ?, sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodIO.getProductCode());
			pstmt.setInt(2, prodIO.getQty());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
	}
	
	//전체재고
	public List<InOutVO> getQtyList() {
		conn = DAO.getConnet();
		String sql = "select product_code, sum(txn_qty) onhand_qty "+
					"from yd_prod_txn "+
					"group by product_code";
		InOutVO qty = null;
		
		List<InOutVO> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qty = new InOutVO();
				qty.setProductCode(rs.getString("product_code"));
//				prod.setProductCode(rs.getString("p.product_code"));
//				prod.setProductName(rs.getString("p.product_name"));
				qty.setQty(rs.getInt("onhand_qty"));
				list.add(qty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
		return list;
	}
	
	//입,출고 기록
	public List<InOutVO> getInOut(){
		conn = DAO.getConnet();
		String sql = "select product_code, txn_qty, receipt_issue_date from yd_prod_txn order by receipt_issue_date ";
		InOutVO qty = null;
		
		List<InOutVO> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qty = new InOutVO();
				qty.setProductCode(rs.getString("product_code"));
				qty.setQty(rs.getInt("txn_qty"));
				qty.setIssueDate(rs.getString("receipt_issue_date"));
				list.add(qty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DAO.close(conn);
		}
		return list;
	}
}
