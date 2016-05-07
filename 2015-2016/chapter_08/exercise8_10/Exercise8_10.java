package exercise8_10;

import java.util.Scanner;

public class Exercise8_10
{
	public static void main(String [] args)
	{
		int arraylength = 0;
		Scanner in = new Scanner(System.in);
		int [] intarray = new int [arraylength];
		while( in.hasNextInt() )
		{
			arraylength++;

			int [] intarraycopy = intarray;
			intarray = new int[arraylength];
			for( int i = 0; i < intarraycopy.length ; i++)
			{
				intarray[i] = intarraycopy[i];
			}
			intarray[ intarray.length - 1 ] = in.nextInt();
			
		}
		in.close();
		int sum = 0;
		for( int i = 0; i < arraylength; i++)
		{
			if(i % 2 == 0 )
				sum += intarray[i];
			else
				sum -= intarray[i];
		}
		
		System.out.println("sum: " + sum );
	}
}