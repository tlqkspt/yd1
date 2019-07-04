package ac.yedam.prod.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.employees.common.DAO;

import ac.yedam.prod.InOutVO;

public class InOutDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 입고처리
	public void inService(InOutVO prodIO) {
		conn = DAO.getConnet();

		String sql = "{call create_receipt_proc(?,?)}"; // 20190703 수정
//		String sql = "insert into yd_prod_txn (product_code, txn_qty, receipt_issue_date )" + "values(?, ?, sysdate )";	//기존코드

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

	// 전체재고
	/*
	 * select v.product_code, p.product_name, v.onhand_qty from onhand_view v JOIN
	 * YD_PRODUCT p ON v.product_code = p.product_code;
	 */

	public List<InOutVO> getQtyList() {
		conn = DAO.getConnet();

		// 기존코드
//		String sql = "select product_code, sum(txn_qty) onhand_qty "+
//					"from yd_prod_txn "+
//					"group by product_code";
//		InOutVO qty = null;
		
		// 수정코드
		String sql = "select * from yedam_prod_onhand";
		InOutVO qty;

		List<InOutVO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qty = new InOutVO();
				qty.setProductCode(rs.getString("product_code"));
//				prod.setProductCode(rs.getString("p.product_code"));
//				prod.setProductName(rs.getString("p.product_name"));
				qty.setQty(rs.getInt("onhand_qty"));
				list.add(qty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	// 입,출고 기록
	public List<InOutVO> getInOut() {
		conn = DAO.getConnet();
		String sql = "select product_code, txn_qty, receipt_issue_date from yd_prod_txn order by receipt_issue_date ";
		InOutVO qty = null;

		List<InOutVO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qty = new InOutVO();
				qty.setProductCode(rs.getString("product_code"));
				qty.setQty(rs.getInt("txn_qty"));
				qty.setIssueDate(rs.getString("receipt_issue_date"));
				list.add(qty);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	// 입출고 목록 적용
	public void setInOutList(String num) {
		conn = DAO.getConnet();
		int n;
		String sql = "{call receipt_purchase_no(?)}"; //receipt_purchase_no(p_purchase_no VARCHAR2)
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			n = pstmt.executeUpdate();
			System.out.println("뭐지 "+n);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	// 입고,출고품목리스트
	public int qtySellList(List<InOutVO> sellList) {
		conn = DAO.getConnet();
		int n = 0;

		String sql1 = "select MAX(purchase_no) from purchase_info";
		String strMax = null;
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();

//			max = rs.getInt("purchase_no");
			while (rs.next()) { // 현재 테이블 purchase_no 최대값 저장
				strMax = rs.getString("MAX(purchase_no)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql2 = "insert into purchase_info values( ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql2);
			for (InOutVO sell : sellList) {
				if (strMax == null) // purchase_no null이면 1로지정 아니면 +1해서 다음번호로쓴다
					pstmt.setInt(1, 1);
				else
					pstmt.setInt(1, Integer.parseInt(strMax) + 1); // str값은 위에서 고정했음

				pstmt.setString(2, sell.getProductCode());
				pstmt.setInt(3, sell.getQty());
				n = pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return n;

	}

//	// 입고품목
//	public void qtyBuyList(List<InOutVO> prodIO) {
//		conn = DAO.getConnet();
//		String sql1 = "select MAX(purchase_no) from purchase_info";
//		int max;
//		String str = null;
//		try {
//			pstmt = conn.prepareStatement(sql1);
//			rs = pstmt.executeQuery();
//
////			max = rs.getInt("purchase_no");
//			while (rs.next()) {
//				str = rs.getString("MAX(purchase_no)");
//				System.out.println(str);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String sql2 = "insert into purchase_info values( ?, ?, ?)";
//
//		try {
//			pstmt = conn.prepareStatement(sql2);
//			for (InOutVO sell : sellList) {
//				if (str == null)
//					pstmt.setInt(1, 1);
//				else
//					pstmt.setInt(1, Integer.parseInt(str)+1);	//str값은 위에서 고정했음
//				
//				pstmt.setString(2, sell.getProductCode());
//				pstmt.setInt(3, sell.getQty());
//				pstmt.executeUpdate();
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			DAO.close(conn);
//		}
//
//	}
}
