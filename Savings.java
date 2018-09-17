package BankAcoountApp;

public class Savings extends Account {
	private int boxID;
	private int boxKey;
	
	public Savings(String name,String sSN,double initDeposit) {
		super(name,sSN,initDeposit);
		accountNumber = "1"+accountNumber;
		setBox();
	}
	
	
	public void setRate() {
		rate = getBaseRate()-0.25;
		
	}
	
	private void setBox() {
		boxID = (int)(Math.random()*Math.pow(10, 3));
		boxKey = (int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println("Your Account features:");
		System.out.println("BoxID="+boxID+"\nBoxKey="+boxKey+"\nRate="+rate+"%");
	
	}
}
