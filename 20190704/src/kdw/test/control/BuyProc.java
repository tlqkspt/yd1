package kdw.test.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public void buyProd() {
		// TODO Auto-generated method stub
		System.out.println();
	}

	public void cancleProd() {
		// TODO Auto-generated method stub

	}

	public void cartList() {
		// TODO Auto-generated method stub

	}

	public void addCart() {
		// TODO Auto-generated method stub
		List<Product> prodlist = buyDao.prodList();
		String choice;
		do {
			System.out.println("어떤 제품을 담겠습니까(모델명 입력)");
			String model = sc.nextLine();
			Product prod = new Product();
			prod = buyDao.getInfo(model);
			buyDao.addCart(prod);
			System.out.println("쇼핑계속할까요?");
			choice = sc.nextLine();
		} while (choice == "y" || choice == "Y");
		
	}

	public void prodList() {
		// TODO Auto-generated method stub
		List<Product> prodlist = buyDao.prodList();
		// System.out.println(prodlist.isEmpty());
		// prodlist = buyDao.prodList();

		for (Product prod : prodlist) {
			System.out.print(prod.getModel() + "  ");
			System.out.print(prod.getName() + "  ");
			System.out.println(prod.getValues());

		}

	}

}
