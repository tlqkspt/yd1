package ac.yedam.prod.control;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ac.yedam.prod.InOutVO;
import ac.yedam.prod.ProductVO;
import ac.yedam.prod.impl.InOutServiceImpl;
import ac.yedam.prod.impl.ProductServiceImpl;

public class ProdProc {
	Scanner sc = new Scanner(System.in);
	InOutServiceImpl inOutService = InOutServiceImpl.getInstance();
	ProductServiceImpl prodService = ProductServiceImpl.getInstance();

	public void excute() { // 실행
		int menu = 0;

		while (true) {
			try {
				System.out.println("======메인메뉴=====");
				System.out.println("1)상품  2)재고  3)구매,판매정보 생성  4)종료");

				menu = sc.nextInt();

				if (menu == 1) {
					System.out.println(" --상품-- ");
					System.out.println("1)상품조회  2)상품등록  3)상품변경  4)전체상품 9)상품삭제 5)상위메뉴");
					menu = sc.nextInt();
					sc.nextLine();
					if (menu == 1)
						getProd(); // 상품조회
					else if (menu == 2)
						insertProd(); // 상품등록
					else if (menu == 3)
						changeProd(); // 상품변경
					else if (menu == 4)
						getProdList(); // 전체상품
					else if (menu == 5)
						continue;
					else if (menu == 9)// 상품삭제
						deleteProd();

					else
						System.out.println("===잘못된 번호===");
				} // 메뉴1끝

				else if (menu == 2) {
					System.out.println("==재고==");
					System.out.println("1)입고처리 2)출고처리 3)전체재고 4)입출고 기록  5)상위메뉴");
					menu = sc.nextInt();
					sc.nextLine();
					if (menu == 1)
						inService(); // 입고처리
					else if (menu == 2)
						outService(); // 출고처리
					else if (menu == 3)
						getQtyList(); // 전체재고
					else if (menu == 4)
						getInOut(); // 입출고기록
					else if (menu == 5)
						continue;

					else
						System.out.println("===잘못된 번호===");
				} // 메뉴2 종료

				// 구매 판매 정보 생성창
				else if (menu == 3) {
					System.out.println("==구매,판매정보 생성===");
					System.out.println("1)구매정보생성  2)판매정보생성 3)상위메뉴");
					menu = sc.nextInt();
					sc.nextLine();
					switch (menu) {
					case 1:
						qtyBuyList();
						break;
					case 2:
						qtySellList();
						break;
					case 3:
						break;
					}
				}

				else if (menu == 4) {
					System.out.println("종료");
					break;
				} else {
					System.out.println("===잘못된 번호===");
				}
			} catch (InputMismatchException e) {
				e.getMessage();
				sc.nextLine(); //// 이거안해주면 계속반복됨
				System.out.println("숫자입력바람");
			} catch (NullPointerException e) {
				e.getMessage();
				System.out.println("없는제품입니다 /엔터");
				sc.nextLine();

			}
		} // 반복문 종료

	}

	private void qtySellList() {
		// TODO Auto-generated method stub
		
		List<InOutVO> sellList = new ArrayList<InOutVO>();		//반복문안에있어서 계속초기화됨
		
		while (true) {
			System.out.println("판매할 제품코드");
			String prodCode = sc.nextLine();
			System.out.println("판매할 수량");
			int qty = sc.nextInt();
			sc.nextLine();
			InOutVO inOutVO = new InOutVO(prodCode, qty, null);

			sellList.add(inOutVO);
			
			System.out.println("계속 입력 하시겠습니까?  Y/N");
			String YN = sc.nextLine();
			
			if(YN.equals("n") || YN.equals("N") ) {
				break;
			}
		}
		inOutService.qtySellList(sellList);
	}

	private void qtyBuyList() {
		// TODO Auto-generated method stub

	}

	//////// 기존코드

	public void getProd() { // 상품조회
		System.out.println("조회할 상품 code 입력: ");
		String prodCode = sc.nextLine();
		prodCode = prodCode.toUpperCase(); // 대문자
		ProductVO prod = prodService.getProd(prodCode);
//		System.out.println("================================");
		prod.showInfo();
	}

	public void insertProd() { // 상품 등록
		System.out.println("등록할 상품의 코드: ");
		String prodCode = sc.nextLine();
		if (prodService.getProd(prodCode) == null) {
			System.out.println("등록할 상품의 이름: ");
			String prodName = sc.nextLine();
			prodCode = prodCode.toUpperCase(); // 대문자

			System.out.println("등록할 상품의 가격: ");
			int prodPrice = sc.nextInt();
			ProductVO prod = new ProductVO(prodCode, prodName, prodPrice);

			prodService.insertProd(prod);
		} else
			System.out.println("==중복된코드입니다==");
	}

	public void changeProd() { // 상품수정? 변경
		System.out.println("변경할 상품의 코드: ");
		String prodCode = sc.nextLine();
		ProductVO prod = prodService.getProd(prodCode);
		prod.showInfo();

//		System.out.println("코드변경: ");   추후수정
//		prodCode = sc.nextLine();
//		prod.setProductCode(prodCode);

		System.out.println("1)이름변경  2)가격변경  3)모두변경");
		int chprod = sc.nextInt();
		sc.nextLine();
		if (chprod == 1) {
			System.out.println("이름변경: ");
			String prodName = sc.nextLine();
			prod.setProductName(prodName);
			prodService.changeProd(prod);
		} else if (chprod == 2) {
			System.out.println("가격변경: ");
			int prodPrice = sc.nextInt();
			prod.setProductPrice(prodPrice);
			prodService.changeProd(prod);
		} else if (chprod == 3) {
			System.out.println("이름변경: ");
			String prodName = sc.nextLine();
			prod.setProductName(prodName);
			System.out.println("가격변경: ");
			int prodPrice = sc.nextInt();
			prod.setProductPrice(prodPrice);
			prodService.changeProd(prod);
		}
		prod.showInfo();
	}

	// 전체상품.
	public void getProdList() {
		List<ProductVO> list = prodService.getProdList();
		System.out.println("=============================================");
		for (ProductVO prod : list) {
			prod.showInfo();
		}
	}

	// 상품삭제
	public void deleteProd() {
		System.out.println("삭제할 상품 코드: ");
		String prodCode = sc.nextLine();
		ProductVO prod = prodService.getProd(prodCode);
		prod.showInfo();
		System.out.println("정말삭제? Y/N");
		String del = sc.nextLine();
		if (del.equals("Y") || del.equals("y")) {
			prodService.deletProd(prodCode);
			System.out.println("삭제됨");
		}
	}

	///////////////

	// 입고처리
	public void inService() {
		ProdProc prodp = new ProdProc();
		prodp.getProdList();

		System.out.println("입고된 물품의 코드: ");
		String prodCode = sc.nextLine();
		prodCode = prodCode.toUpperCase(); // 대문자
		// 제품 존재여부 확인
		ProductVO prod = prodService.getProd(prodCode);

		if (prod != null) {
			System.out.println("입고된 물품의 수량: ");
			int qty = sc.nextInt();
			sc.nextLine();
			String today = null; // 오늘날짜
			InOutVO prodIO = new InOutVO(prodCode, qty, today);
			inOutService.inService(prodIO);
		} else
			System.out.println("없는 제품입니다");
	}

	// 출고처리
	public void outService() {

		boolean check = false; // 출고량 재고량 비교
		ProdProc prodp = new ProdProc();
		prodp.getQtyList();

		System.out.println("출고된 물품의 코드: ");
		String prodCode = sc.nextLine();
		prodCode = prodCode.toUpperCase(); // 대문자
		System.out.println(prodCode);

		// 제품 존재여부 확인
		ProductVO prod = prodService.getProd(prodCode);
		if (prod != null) {
			System.out.println("출고된 물품의 수량: ");
			int qty = sc.nextInt();
			sc.nextLine();
			qty = -qty; // 출고 -로

			List<InOutVO> list = inOutService.getQtyList(); // 단건 재고 조회 없어서
			for (InOutVO qty1 : list) { // 전체재고 불러와서 비교함
				if (qty1.getProductCode().equals(prodCode)) {

					check = qty1.getQty() >= -qty;
				}
			}
			if (check) {
				String today = null; // 오늘날짜
				InOutVO prodIO = new InOutVO(prodCode, qty, today);
				inOutService.inService(prodIO);
			} else
				System.out.println("재고량 초과");
		} else
			System.out.println("없는 제품입니다");
	}

	// 전체재고
	public void getQtyList() {
		List<InOutVO> list = inOutService.getQtyList();
		for (InOutVO qty : list) {
			qty.showInfo();
		}
	}

	// 입출고 기록
	public void getInOut() {
		List<InOutVO> list = inOutService.getInOut();
		for (InOutVO qty : list) {
			qty.showInfo();
		}
		System.out.println("=========================");
		list = inOutService.getQtyList();
		for (InOutVO qty : list) {
			qty.showInfo();
		}
	}

}
