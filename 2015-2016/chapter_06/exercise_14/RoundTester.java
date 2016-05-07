package exercise_14;

import java.util.Scanner;

public class RoundTester {

	public static void main(String [] args)
	{
		System.out.println("Enter two floating point numbers: ");
		Scanner in = new Scanner(System.in);
		Rounding r1 = new Rounding();
		boolean isequal = r1.round(in.nextFloat(), in.nextFloat() );
		if(isequal == true )
			System.out.println("They're equal");
		else
			System.out.println("They're not equal");
		in.close();
				
	}
}
