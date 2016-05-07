package randwalk;

import java.util.Scanner;

public class RandWalkTester {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int totaldistance = in.nextInt();
		RandWalk r1 = new RandWalk();
		for(int i = 0; i < 100; i++)
		{
			r1.move();
		}
		System.out.println(r1.distance() + " street-lengths away from origin");
		System.out.println(totaldistance + " total streets travelled");
	}
}
