package randwalk;

import java.awt.geom.Point2D;

public class RandWalk {
	private Point2D coordinate;	
	public RandWalk()
	{
		coordinate = new Point2D.Double(0, 0);
	}
	
	public double distance()
	{
		return( Math.sqrt(Math.pow(coordinate.getX(), 2) + Math.pow(coordinate.getY(),2) ) );
	}
	/**
	 * simulates the drunkie moving
	 * every time method is called, drunkie moves 1 unit in a random direction
	 */
	public void move()
	{
		int xtemp = (int)coordinate.getX();
		int ytemp = (int)coordinate.getY();
		
		int direction = (int)(Math.random() * 4);
		switch(direction)
		{
		case 0: 
			coordinate.setLocation(xtemp, ytemp + 1);
			break;
		case 1: 
			coordinate.setLocation(xtemp, ytemp - 1);
			break;
		case 2: 
			coordinate.setLocation(xtemp + 1, ytemp);
			break;
		case 3: 
			coordinate.setLocation(xtemp - 1, ytemp);
			break;
		}
		
		//IF DRUNKIE IS AT ANY OF THE BORDERS: 
		if( coordinate.getX() >= 5)
			coordinate.setLocation(5, coordinate.getY() );
		else if(coordinate.getX() <= -5)
			coordinate.setLocation(-5, coordinate.getY() );
		
		if(coordinate.getY() >= 5)
			coordinate.setLocation(coordinate.getX(), 5);
		else if(coordinate.getY() <= -5)
			coordinate.setLocation(coordinate.getX(), -5);
		System.out.println(coordinate);
	}
	
}
