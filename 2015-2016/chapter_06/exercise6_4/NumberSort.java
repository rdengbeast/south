package exercise6_4;
import java.util.Scanner;
public class NumberSort {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		float a, b, c, a2, b2, c2;
		a2 = 0;
		b2 = 0;
		c2 = 0;
		System.out.println("enter three numbers!");
		a = in.nextFloat();
		b = in.nextFloat();
		c = in.nextFloat();
		
		a2 = Math.min( Math.min(a, b), c);
		c2 = Math.max( Math.max(a, b), c);
		b2 = a + b + c - a2 - c2;
		
		in.close();
		System.out.println(a2 + "\n" + b2 + "\n" + c2 );
	}
}
