package exercise6_16;

public class Paycheck {

	public double wage, hours;
	public Paycheck( double w, double h)
	{
		wage = w;
		hours = h;
	}
	public double calculatepay()
	{
		if(hours >= 40)
			return( ( hours - 40) * 1.5 * wage + hours * wage );
		else
			return( hours * wage);
	}
}
