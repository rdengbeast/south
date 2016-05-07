package exercise13_6;

public abstract class Worker {

	private String name;
	private double salary;
	
	public Worker(String name, double sal)
	{
		this.name = name;
		salary = sal;
	}
	public double getSal()
	{
		return salary;
	}
	public String getName()
	{
		return name;
	}
	public abstract double computePay(int hours);
}
