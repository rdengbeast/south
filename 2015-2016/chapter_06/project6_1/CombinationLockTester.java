package project6_1;

import java.util.Scanner;

public class CombinationLockTester {

	public static void main(String [] args)
	{
		int timeslockisset = 0;
		CombinationLock c1 =new CombinationLock('D', 'E', 'G');
		
		System.out.println("Entering: enter CAPITAL letter to set lock or type peel to view combo");  
		Scanner in = new Scanner(System.in);
		
		if(in.next().equals("peel"))
			System.out.println("D, E, G");
		
		boolean exit = false;
		do{
			System.out.println("Type entry, 'close' to close, or 'exit' to exit");
			String input = in.next();
			if( input.length() == 1 && !c1.lockisopen )
			{
				timeslockisset++;
				char inputchar = input.charAt(0); 
				c1.setLock( inputchar );
				
				if(timeslockisset >= 3)
				{
					if(c1.lockisopen )
						System.out.println("lock has been opened! close lock to continue");
					else
						System.out.println("Lock remains closed");		
				}
			}			
			else
			{
				if( input.toLowerCase().equals("close") )
				{
					c1.closeLock();
					System.out.println("lock closed");
				}
				else if( input.toLowerCase().equals("exit") )
					exit = true;
			}
		}while(exit == false);
		System.out.println("Lock was set "+ timeslockisset + " times.");
		in.close();
	}
}
