package exercise7_4;

import java.awt.geom.Point2D;

import exercise7_3.Cannonvert;

public class CannonballtTest {

	public static void main(String [] args)
	{
		double initv = 150;
		Cannonball v1 = new Cannonball(initv, 45);
		int millispassed = 0;
		Point2D pos = v1.getPos();
		while(pos.getY() >= 0 )
		{			

			if( millispassed % 100 == 0 )
			{
				System.out.println();
				System.out.println("time: " + millispassed/100);
				System.out.println("Horizontal: " + pos.getX());
				System.out.println("Vert: " + pos.getY() );
			}			
			v1.update();			
			pos = v1.getPos();

			millispassed++;
		}
		System.out.println();
		System.out.println("time: " + millispassed/100.0);
		System.out.println("Horizontal: " + pos.getX());
		System.out.println("Vert: " + pos.getY() );
	}
	
}

