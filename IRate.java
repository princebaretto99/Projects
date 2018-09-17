package BankAcoountApp;

public interface IRate {
	//method which returns base rate
	default double getBaseRate() {
		return 2.5;
	}
}
