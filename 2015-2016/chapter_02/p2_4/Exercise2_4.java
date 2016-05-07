package p2_4;
import java.awt.Rectangle;

public class Exercise2_4 {

	public static void main(String[] args)
	{
		Rectangle r1 = new Rectangle(10, 50, 10, 40);
		Rectangle r2 = new Rectangle( 30, 70, 40, 50);
		
		Rectangle intersection = r1.intersection(r2);
		
		double area = Math.abs(intersection.getHeight() * intersection.getWidth() );
		
		System.out.println("Intersection: " + area );
	}
	
}
