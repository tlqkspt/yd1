package ac.yedam.prod.control;

import java.security.Provider.Service;
import java.sql.SQLException;
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
				System.out.println("1)상품  2)재고  3)종료");

				menu = sc.nextInt();

				if (menu == 1) {
					System.out.println(" --상품-- ");
					System.out.println("1)상품조회  2)상품등록  3)상품변경  4)전체상품  5)상위메뉴");
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
					else if (menu ==4 ) 
						getInOut();		//입출고기록
					else if (menu == 5)
						continue;

					else
						System.out.println("===잘못된 번호===");
				} // 메뉴2 종료

				else if (menu == 3) {
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

	public void getProd() { // 상품조회
		System.out.println("조회할 상품 code 입력: ");
		String prodCode = sc.nextLine();
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

	///////////////

	// 입고처리
	public void inService() {
		System.out.println("입고된 물품의 코드: ");
		String prodCode = sc.nextLine();
		System.out.println("입고된 물품의 수량: ");
		int qty = sc.nextInt();
		sc.nextLine();
		String today = null; // 오늘날짜
		InOutVO prodIO = new InOutVO(prodCode, qty, today);
		inOutService.inService(prodIO);
	}

	// 출고처리
	public void outService() {
		
		boolean check = false; // 출고량 재고량 비교
		
		System.out.println("출고된 물품의 코드: ");
		String prodCode = sc.nextLine();

		System.out.println("출고된 물품의 수량: ");
		int qty = sc.nextInt();
		sc.nextLine();
		qty = qty * -1; // 출고 -로

		List<InOutVO> list = inOutService.getQtyList();
		for (InOutVO qty1 : list) {
			if (qty1.getProductCode().equals(prodCode)) {

				check = qty1.getQty() > qty * -1;
			}
		}
		if (check) {
			String today = null; // 오늘날짜
			InOutVO prodIO = new InOutVO(prodCode, qty, today);
			inOutService.inService(prodIO);
		}else System.out.println("재고량 초과");
	}


	// 전체재고
	public void getQtyList() {
		List<InOutVO> list = inOutService.getQtyList();
		for (InOutVO qty : list) {
			qty.showInfo();
		}
	}
	
	//입출고 기록
	public void getInOut() {
		List<InOutVO> list = inOutService.getInOut();
		for(InOutVO qty : list) {
			qty.showInfo();
		}
		System.out.println("=========================");
		list = inOutService.getQtyList();
		for (InOutVO qty : list) {
			qty.showInfo();
		}
	}
	
}