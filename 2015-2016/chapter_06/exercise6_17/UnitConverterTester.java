package exercise6_17;
import java.util.Scanner;

public class UnitConverterTester {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter starting value: ");
		float start = in.nextFloat();
		System.out.println("Enter starting unit: ");
		String startu = in.next();
		boolean isconin;
		if(startu == "in" || startu == "ft" || startu == "mi" )
			isconin = true;
		else
			isconin = false;
		System.out.println("Enter ending unit: ");
		String endu = in.next();
		
		UnitConverter u1 = new UnitConverter(start, isconin, startu, endu );
		in.close();
		System.out.println("The new conversion is: " + u1.convert());
	}
}
