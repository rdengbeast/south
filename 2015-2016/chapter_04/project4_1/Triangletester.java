package project4_1;
import java.util.Scanner;

public class Triangletester {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		int ax, ay, bx, by, cx, cy;
		
		System.out.println("enter coordinates! ");
		System.out.println("a x coordinate: ");
		ax = in.nextInt();
		System.out.println("a y coordinate: ");
		ay = in.nextInt();
		System.out.println("b x coordinate: ");
		bx = in.nextInt();
		System.out.println("b y coordinate: ");
		by = in.nextInt();
		System.out.println("c x coordinate: ");
		cx = in.nextInt();
		System.out.println("c y coordinate: ");
		cy = in.nextInt();
		
		Triangle tri = new Triangle(ax, ay, bx, by, cx, cy );
		System.out.println("lengths: "+ "\t" + "a: " + tri.getSides('a') + "\t b: " + tri.getSides('b') + "\t c: " + tri.getSides('c') );
		System.out.println("perimeter: " + "\t" + tri.perimeter() );
		System.out.println("area: " + "\t" + tri.area() );
		System.out.print("angles:");
		for( int i = 0; i < 3; i++ )
			System.out.print("\t" + tri.angles()[i]);
		in.close();
		
	}
}
