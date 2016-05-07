package monty_hall;

import java.util.Scanner;

public class MontyHallTester {
	
	public static void main(String[] args)
	{
		boolean cont = true;
		
		Scanner in = new Scanner( System.in );
		
		do{
			MontyHall m1 = new MontyHall();
			//SETS UP THE DOORS AND WELCOME MESSAGE
			m1.drawdoors(3);
			System.out.println("Welcome! Choose a door to open.");
	
			//FIRST GUESS
			int firstguess = in.nextInt();
			int firstgoatendoor = m1.opendoor(firstguess, true, true);
			System.out.println( "Door " + firstgoatendoor + " has a goat! ");
			
			//SECOND GUESS
			System.out.println( "Switch or keep your initial guess? Type switch or keep!");
			if(in.next().equals("switch") )
			{
				System.out.println("switched");
				for(int i = 1; i <= 3; i++)
				{
					if((i != firstguess )&( i != firstgoatendoor ))
						m1.opendoor(i, false, true);
				}
			}
			else
			{
				m1.opendoor( firstguess, false, false);
			}
			//DID PLAYER WIN?
			System.out.println(m1.wonornot());
			
			//REVEAL WHERE GOAT WAS
			System.out.println(m1.getPrize() + " had a prize! Type again to play again or stats to see stats...");		
			
			if(in.next().equals("stats" ) )
			{
				m1.getStats();
				cont = false;
			}
			else
				cont = true;
			
		}while(cont);
	
		in.close();

	}

}

