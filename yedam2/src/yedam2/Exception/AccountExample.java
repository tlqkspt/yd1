package yedam2.Exception;

class Account{
	private long balance;
	Account(){}
	public long getBalance() {
		return balance;
	}
	public void deposit(int money) {
		balance += money;
	}
	public void withdraw(int money) throws BalanceInsufflentException {
		if(balance<money)
			throw new BalanceInsufflentException("잔고부족"+(money - balance));
		balance -= money;
	}
}


public class AccountExample {
	public static void main(String[] args) {
		Account account = new Account();
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance());
		try {
			account.withdraw(30000);
		} catch (BalanceInsufflentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("프로그램 종료.");
	}
}
