package BankAcoountApp;

public class Checking extends Account {
	//properties for checking account
	private int debitCardNumber;
	private int debitCardPin;
	//constructor to initialize the checking acc properties
	
	public Checking(String name,String sSN,double initDeposit) {
		super(name,sSN,initDeposit);
		accountNumber = "2"+accountNumber;
		setDebitCard();
	}
	
	public void setRate() {
		rate = getBaseRate()* 0.15;
		
	}
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random()*Math.pow(10, 12));
		debitCardPin = (int)(Math.random()*Math.pow(10, 4));
	}
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println("Your Account features:");
		System.out.println("DebitCard Number="+debitCardNumber+"\nDebitCard Pin="+debitCardPin+"\nRate="+rate+"%");
	}
}
