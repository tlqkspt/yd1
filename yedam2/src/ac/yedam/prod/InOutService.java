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
	
	//입,출고 기록 삭제
	//public void delService(InOutVO prodIO);
}
