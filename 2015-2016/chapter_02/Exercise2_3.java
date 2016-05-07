import java.awt.Rectangle;

public class Exercise2_3 {

	public static void main(String [] args)
	{
		int x = 10; //x coordinate;
		int y = 50; //y cooridnate;
		int width = 10;
		int height = 40;
		
		Rectangle r1 = new Rectangle( x, y, width, height );
		System.out.println("location of rectangles: " + x + "," + y);
		r1.translate( width, 0);
		System.out.println( r1.getX() + ", " + r1.getY() );
		r1.translate( -1 * (width), height);
		System.out.println( r1.getX() + ", " + r1.getY() );
		r1.translate(width, 0);
		System.out.println( r1.getX() + ", " + r1.getY() );
		
	}
}
