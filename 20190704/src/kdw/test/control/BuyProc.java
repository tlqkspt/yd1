package kdw.test.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kdw.test.BuyProd.Buy;
import kdw.test.common.DAO;
import kdw.test.common.mail.MailSend;
import kdw.test.impl.BuyDAO;
import kdw.test.prod.Product;

public class BuyProc {

	Scanner sc = new Scanner(System.in);
	int menu = 0;
	BuyDAO buyDao = new BuyDAO();
	boolean end = true;

	public void shopping() {
		while (end) {
			System.out.println("1)제품 목록  2)장바구니조회  0)종료");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
			case 1:

				prodList();

				System.out.println("1)장바구니담기 0)상위메뉴");
				menu = sc.nextInt();
				sc.nextLine();
				switch (menu) {
				case 1:
					addCart();
					break;
				case 0:
					break;
				}

				break;

			case 2: // 장바구니조회
				cartList();
				System.out.println("1)주문취소 2)구매 0)상위메뉴");
				menu = sc.nextInt();
				sc.nextLine();
				switch (menu) {
				case 1:
					cancleProd();
					break;
				case 2:
					buyProd();
					break;
				case 0:
					break;
				}
				break;

			case 0:
				System.out.println("종료");
				end = false;
				break;

			}

		}

	}
	
	
	//r결제
	public void buyProd() {
		List<Product> cart = new ArrayList<Product>();
		cart = buyDao.getCartList();
		int sumPrice =0;
		
		for (Product prod : cart) {
			sumPrice += prod.getValues();
		}
		
		System.out.println("총금액 "+sumPrice+"원 결제하시겠습니까?");
		System.out.println(" [  Y  /  N  ]");
		String choice = sc.nextLine();
		
		if(choice.equals("y") || choice.equals("Y")) {
			System.out.println(sumPrice+"원 결제하셨습니다.");
			
			//이메일로 결제내역 날려준다
			Buy buy = new Buy();
			
			buy = buyDao.orderSet(cart);
			MailSend mail = new MailSend();
			mail.mailRun(buy);
				
			
			buyDao.delCart();
		}else {
			System.out.println("취소되었습니다.");
		}
	}

	public void cancleProd() {
		// TODO Auto-generated method stub

	}

	public void cartList() {		//카트보기
		// TODO Auto-generated method stub
		List<Product> prodlist = new ArrayList<Product>();
		System.out.println("=====내 장바구니=====");
		
		prodlist = buyDao.getCartList();
		
		for (Product prod : prodlist) {
			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getQty() + "  ");
			System.out.println(prod.getValues());
		}
	}

	public void addCart() {		//카트에담기
		// TODO Auto-generated method stub
		List<Product> prodlist = new ArrayList<Product>();
		String choice;
		do {
			System.out.println("어떤 제품을 담겠습니까(모델명 입력)");
			String model = sc.nextLine();
			Product prod = new Product();
			prod = buyDao.getInfo(model);

			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getName() + "  ");
			System.out.println(prod.getValues());

			System.out.println("몇개살래요?");
			int qty = sc.nextInt(); sc.nextLine();
			prod.setQty(qty);

			prodlist.add(prod);

			System.out.println("쇼핑계속할까요? Y/N");
			choice = sc.nextLine();
		} while (choice.equals("y") || choice.equals("Y"));
		buyDao.addCart(prodlist);
	}

	public void prodList() {		//제품목록
		// TODO Auto-generated method stub
		List<Product> prodlist = buyDao.prodList();
		
		for (Product prod : prodlist) {
			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getName() + "  ");
			System.out.println(prod.getValues());

		}

	}

}
