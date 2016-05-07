package exercise6_2;
import java.util.Scanner;
public class Exercise6_2 {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("enter card notation: ");
		String x = in.next();
		if(x.equals("A"))
			System.out.println("Ace");
		else if(x.equals("J"))
			System.out.println("Jack");
		else if(x.equals("K"))
			System.out.println("King");
		else if(x.equals("Q"))
			System.out.println("Queen");
		else
		{
			for(int i = 2; i <= 10; i++)
			{
				if(i == Integer.parseInt(x) )
					System.out.println(i);
			}
		}
		in.close();
	}
	
}

