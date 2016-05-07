package exercise13_2;

public class TimeDepositAccount extends SavingsAccount
{
	private int monthstomature;
	private double earlyfee = 40;
	
	public TimeDepositAccount(double interestrate, int months)
	{
		super(interestrate);
		monthstomature = months;
	}
	
	public void addInterest()
	{
		super.addInterest();
		monthstomature--;
	}
	
	public void withdraw(double amount)
	{
		if (monthstomature > 0)
			super.withdraw(earlyfee);
		
		super.withdraw(amount);
	}
}
