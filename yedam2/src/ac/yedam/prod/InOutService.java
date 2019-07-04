package ac.yedam.prod;

import java.util.List;

public interface InOutService {
	//입고처리
	public void inService(InOutVO prodIO);
	//출고처리
	public void outService(InOutVO prodIO);
	//전체재고
	public List<InOutVO> getQtyList();
	//입출고 기록
	public List<InOutVO> getInOut();
	
	//입고 리스트생성
	public void qtyBuyList(List<InOutVO> prodIO);
	
	//출고리스트생성
	public int qtySellList(List<InOutVO> prodIO);
	
	//입출고 리스트 적용
	public void setInOutList(String num);
	
	//입,출고 기록 삭제
	//public void delService(InOutVO prodIO);
}
