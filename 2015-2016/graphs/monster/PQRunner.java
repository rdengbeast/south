package monster;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class PQRunner
{
	public static void main ( String[] args )
	{			
		int h, w, a;

		YourPQ test = new YourPQ();

		Scanner keyboard=new Scanner(System.in);
		//loop to read in values and instantiate your Objects
//		System.out.println("number of monsters: ");
//		int x = keyboard.nextInt();
//		for(int i = 0; i < x; i++)
//		{
//			System.out.print("h");
//			h = keyboard.nextInt();
//			System.out.print("\nw");
//			w = keyboard.nextInt();
//			System.out.print("\na");
//			a = keyboard.nextInt();
//			
//			test.add(new Monster(h, w, a));
//		}
	
		test.add(new Monster(1, 1, 1));
		test.add(new Monster(1, 2, 3));
		test.add(new Monster(2, 2, 2));
		test.add(new Monster(3, 2, 1));
		test.add(new Monster(2, 1, 3));
		test.add(new Monster(2, 3, 1));
		test.add(new Monster(3, 1, 2));
		test.add(new Monster(3, 3, 3));
	


		System.out.println(test);
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		System.out.println("getMin() - " + test.getMin());
		System.out.println("removeMin() - " + test.removeMin());		
		System.out.println(test);
		
		//add more test cases
		
			
	}
}