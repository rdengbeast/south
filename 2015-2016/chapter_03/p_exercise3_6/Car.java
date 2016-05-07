package p_exercise3_6;

public class Car 
{

	public double tank;
	public double mpg;
	
	public Car()
	{
		tank = 0;
		mpg = 25.6;
	}
	
	public void addGas( int x)
	{
		tank = tank + x;
	}
	public double getGas()
	{
		return tank;
	}
	public void drive( int x )
	{
		tank = tank - ( x / mpg );
		if( tank <= 0 )
		{
			tank = 0;
			System.out.println("Ran out of gas" );
		}
	}
	
}
