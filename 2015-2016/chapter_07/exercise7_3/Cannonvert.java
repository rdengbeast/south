package exercise7_3;

public class Cannonvert {

	private double velocity;
	private double position;
	private double deltaT = 0.01;
	private final double g;
	
	public Cannonvert( double initv )
	{
		velocity = initv;
		position = 0;
		deltaT = 0.01;
		g = 9.81;
	}
	
	public void update()
	{		
		position = position + velocity * deltaT;
		velocity = velocity - g * deltaT;

	}
	public double getPos()
	{
		return position;
	}
	public double getCalcPos( double timepassed, double initv)
	{
		return( -0.5 * g * timepassed * timepassed + initv * timepassed ); 
	}
}
