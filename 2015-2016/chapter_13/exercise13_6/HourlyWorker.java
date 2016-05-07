package exercise13_6;

public class HourlyWorker extends Worker{

	public HourlyWorker(String name, double sal)
	{
		super(name, sal);
	}
	@Override
	public double computePay(int hours)
	{
		// TODO Auto-generated method stub
		if(hours <= 40 )
			return super.getSal() * hours;
		else
			return super.getSal() * hours * 1.5;
	}

}
