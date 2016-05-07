package exercise13_6;

public class SalariedWorker extends Worker{

	public SalariedWorker(String name, double salary)
	{
		super(name, salary);
	}
	@Override
	public double computePay(int hours) 
	{
		return hours * super.getSal();
	}

}
