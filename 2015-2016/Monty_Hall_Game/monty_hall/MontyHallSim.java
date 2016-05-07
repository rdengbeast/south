package monty_hall;

import java.util.Scanner;

public class MontyHallSim {

	public static void main(String [] args)
	{
		MontyHall m2 = new MontyHall();
		System.out.println("enter times to run: ");
		Scanner in = new Scanner( System.in );
		int numoftimesrun = in.nextInt();
		for(int i = 0; i < numoftimesrun; i++)
		{
			int initdoor = (int)( Math.random() * 3 + 1);
			System.out.println("init guess: " + initdoor);
			int firstgoatendoor = m2.opendoor(initdoor, true, false);
			if(Math.random()*2 > 1)
			{

				System.out.println("switched");
				for(int j = 1; j <= 3; j++)
				{
					if((j != initdoor )&&( j != firstgoatendoor ))
						m2.opendoor(j, false, true);
				}
			}
			else
			{
				System.out.println("kept");
				m2.opendoor( initdoor, false, false);
			}

			//DID PLAYER WIN?
			
			System.out.println("won: " + m2.wonornot());
			
			//REVEAL WHERE GOAT WAS
			
			System.out.println(m2.getPrize() + " had a prize! Type again to play again or stats to see stats...");
		}
		m2.getStats();
		in.close();
	}
}
