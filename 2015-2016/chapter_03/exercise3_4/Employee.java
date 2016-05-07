package exercise3_4;

public class Employee {
	private String name;
	private double salary;
	public Employee()
	{
		name = null;
		salary = 0;
	}
	public Employee(String inputname, double sal)
	{
		name = inputname;
		salary = sal;
	}
	public String returnname()
	{
		return name;
	}
	public double returnsal()
	{
		return salary;
	}
}
