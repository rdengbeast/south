package exercise13_5;

public class Manager extends Employee{
	
	private String department;
	
	public Manager(String name, double sal, String dep)
	{
		super(name, sal);
		department = dep;
	}
	public String toString()
	{
		return(this.getName() + ", " + this.getSalary() + ", " + department);
	}
	public String getDepartment()
	{
		return department;
	}
}
