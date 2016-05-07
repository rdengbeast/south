package exercise7_4;

import java.awt.geom.Point2D;


public class Cannonball {

	private static double degtorad = 0.0174532925;
	private double velocityX;
	private double velocityY;
	private Point2D position;
	private double deltaT = 0.01;
	private final double g;
	
	public Cannonball( double initv, double angle )
	{
		velocityX = initv * Math.cos(angle * degtorad);
		velocityY = initv * Math.sin(angle * degtorad);
		position = new Point2D.Double(0, 0);
		deltaT = 0.01;
		g = 9.81;
	}
	
	public void update()
	{	
		Point2D temppos = position;
		position.setLocation(temppos.getX() + velocityX * deltaT, temppos.getY() + velocityY * deltaT);
		velocityY = velocityY - g * deltaT;

	}
	public Point2D getPos()
	{
		return position;
	}

}
