import java.awt.Rectangle;

public class Exercise2_2 {

	public static void main(String [] args)
	{
		Rectangle r1 = new Rectangle( 5, 10, 10, 40);
		double perimeter = 2 * (r1.getWidth() + r1.getHeight() );
		
		System.out.println("perimeter: " + perimeter + " units" );
	}
}
