package BankAcoountApp;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankAccountApp extends CSV{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	List<Account> accounts = new LinkedList<Account>();
	
	
		
		/*
		Checking chkacc1 = new Checking("Tom Wilson","123456789",1000);
		
		Savings savacc1 = new Savings("Princeton Baretto","534567890",2000);
		savacc1.showInfo();
		savacc1.deposit(5000);
		savacc1.withdraw(200);
		savacc1.transfer("Prince", 500);
		savacc1.compound();
		System.out.println("**********************");
		chkacc1.showInfo();
	*/
		//Read a CSV file and craete new acc
		String file ="D:\\hello.txt";
		List<String[]> newCustomers = CSV.read(file);
		for(String[] customer : newCustomers) {
			
			String name = customer[0];
			String sSN = customer[1];
			String accounttype = customer[2];
			double initDeposit = Double.parseDouble(customer[3]);
			//System.out.println(name +" "+sSN+" "+accounttype+" Rs"+initDeposit);
			if(accounttype.equals("Savings")) {
				accounts.add(new Savings(name,sSN,initDeposit));
			}
			else if(accounttype.equals("Checking")){
				accounts.add(new Checking(name,sSN,initDeposit));
			}
			else {
				System.out.println("Error");
			}
		}
		accounts.get(5).showInfo();
		//String str=accounts.get(5).getAccountnumber();
		//System.out.println(str);
		//accounts.get(0).getName();
		//for(Account acc:accounts) {
			//System.out.println("\n****************");
			//acc.showInfo();
		//}
		System.out.println("Enter the customers account number you want to work on:");
		String updateAccountnumber = in.next();
		
		/*if(accounts.get(5).getAccountnumber() == updateAccountnumber)		//ERROR
		{																	//ERROR
			System.out.println("Match");									//ERROR
		}																	//ERROR
		*/
		for(int i=0;i<7;i++) {
			if(accounts.get(i).getAccountnumber().equals(updateAccountnumber))
			{
				int flag = 0;
				do {
					System.out.println("What operations do you want to do:\n");
					System.out.println("1:Withdraw\n2:Deposit\n3:Transfer\n4:Add Interest\n5:Display Balance");
					int choice = in.nextInt();
					switch(choice) {
					case 1: System.out.println("How much amount is withdrawn:");
							double amt = in.nextDouble();
							accounts.get(i).withdraw(amt);
							break;
						
					case 2: System.out.println("How much amount is deposited:");
							double damt = in.nextDouble();
							accounts.get(i).deposit(damt);
							break;
						
					case 3: System.out.println("Where is the amount being transferred:");
							String nm = in.next();
							System.out.println("How much amount is being transferred:");
							double tamt = in.nextDouble();
							accounts.get(i).transfer(nm, tamt);
							break;
						
					case 4: System.out.println("-------Added interest to the account-----");
							accounts.get(i).compound();
							break;
							
					case 5: accounts.get(i).printBalance();
							break;
						
					case 6: flag = 1;
							break;
							
					default : System.out.println("Invalid choice");
							  break;
					}
				}while(flag != 1);
			}
		}
	}
}