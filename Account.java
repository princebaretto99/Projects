package BankAcoountApp;

public abstract class Account implements IRate {
	//common for savings and checking account
	private String name;
	private String sSn;
	private double balance;
	protected String accountNumber;
	protected double rate;
	private String sSN;
	private static int index = 10000;
	
	
	//constructor to set base properties
	public Account(String name,String sSN,double initDeposit) { 
	
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		
		
		//set accountNumber
		index++;
		this.accountNumber = setAccountNumber();
	
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN =sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber = (int)( Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN+uniqueID+randomNumber;
	}
	
	public void compound() {
		double addInterest = balance * (rate/100);
		System.out.println("Added Interest = Rs "+addInterest);
		balance = balance + addInterest;
		printBalance();
	}
	
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Amount Deposited:Rs "+amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawed amount:Rs "+amount);
		printBalance();
	}
	
	public void transfer(String toWhere,double amount) {
		balance = balance - amount;
		System.out.println("Transfered Rs"+amount+" To "+toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is Rs: "+balance);
	}
	public String getAccountnumber() {
		return accountNumber;
	}
	public void showInfo() {
		System.out.println("Name:"+name+"\nAccount Number"+accountNumber+"\nBalance:"+balance+"\n");
	}
	
}
