package randomint;

public class Randint_tester {

	public static void main(String [] args)
	{
		int sum = 0;
		int lowest = 0;
		int highest = 0;
		Random_In_Between_Int i1 = new Random_In_Between_Int(-50, 100);
		for(int i = 0; i < 5000; i++)
		{
			int a = i1.inbetweenint();
			System.out.println(a);
			sum += a;
			if(a < lowest)
				lowest = a;
			if(a > highest)
				highest = a;
		}
		System.out.println("average: " + sum/5000.0);
		System.out.println("highest: " + highest);
		System.out.println("lowest: " + lowest);
	}
}
