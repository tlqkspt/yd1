package ac.yedam.prod.impl;

import java.util.List;

import ac.yedam.prod.InOutService;
import ac.yedam.prod.InOutVO;

public class InOutServiceImpl implements InOutService {
	private static InOutServiceImpl singleton = new InOutServiceImpl();		//싱글톤
	private InOutServiceImpl() {}
	public static InOutServiceImpl getInstance() {
		return singleton;
	}
	InOutDAO dao = new InOutDAO();
	
	@Override
	public void inService(InOutVO prodIO) {
		// TODO Auto-generated method stub
		dao.inService(prodIO); 
	}
	@Override
	public void outService(InOutVO prodCode) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<InOutVO> getQtyList() {
		// TODO Auto-generated method stub
		return dao.getQtyList();
	}
	@Override
	public List<InOutVO> getInOut() {
		// TODO Auto-generated method stub
		return dao.getInOut();
	}
	
	////추가
	@Override
	public void qtyBuyList(List<InOutVO> prodIO) {
		// TODO Auto-generated method stub
		dao.qtyBuyList(prodIO);
	}
	@Override
	public void qtySellList(List<InOutVO> prodIO) {
		// TODO Auto-generated method stub
		dao.qtySellList(prodIO);
	}
	
	

}
