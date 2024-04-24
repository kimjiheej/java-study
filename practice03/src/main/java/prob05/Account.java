package prob05;

public class Account {
	

   private String accountNo;
   private int balance;
   
   
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		this.balance = 0;
	}

	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	// 입금을 의미하는 save 
	
	public void deposit(int money) {
		System.out.println(accountNo+"계좌에"+money+"만원이 출금되었습니다");
		this.balance -= money;
	}
	
	// 출금을 의미하는 save 
	
	public void save(int money) {
		System.out.println(accountNo+"계좌에"+money+"만원이 입금되었습니다.");
		this.balance += money;
	}
	
	
	
	
}
