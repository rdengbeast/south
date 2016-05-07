package project4_14;
import java.util.Scanner;
public class Miltime_run {

	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("enter first time: ");
		int firstNumber = in.nextInt();
		System.out.println("enter second time: ");
		int secondNumber = in.nextInt();
		Miltime t1 = new Miltime();
		System.out.println( t1.difference(firstNumber, secondNumber));
		in.close();
	}
}
