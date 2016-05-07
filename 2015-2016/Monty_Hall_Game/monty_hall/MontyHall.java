package monty_hall;

public class MontyHall {

	private static int prize, timeswon, timeswonbyswitch, timesswitched, timesplayed;
	private static boolean didswitch;
	private static boolean gotprize;

	public int getPrize()
	{
		return prize;
	}
	public MontyHall()
	{
		gotprize = false;
		prize = (int)( Math.random() * 3 + 1);
	}
	public void choosenewdoor()
	{
		prize = (int)( Math.random() * 3 + 1);
	}
	/**
	 * method that simulates opening a door in Monty Hall game
	 * @param chosendoor	door that is chosen
	 * @param isfirsttimechosen	boolean, is it the first guess or the second?
	 * @return after first guess the door with the goat
	 */
	public int opendoor(int chosendoor, boolean isfirsttimechosen, boolean switched)
	{
		int goatendoor = 0;
		
		if(isfirsttimechosen == true)
		{
			for(int i = 1; i <= 3; i++)
			{
				if( (i != prize )&( i != chosendoor) )
					goatendoor = i;
			}
		}
		else
		{
			if( chosendoor == prize)
				gotprize = true;
			else
				gotprize = false;
			if(switched)
			{
				didswitch = true;
				timesswitched++;
			}
			else
				didswitch = false;
			
			timesplayed++;
		}
		
		return goatendoor;
	}
	
	/**
	 * checks if user won or not
	 * @return string to display on screen
	 */
	public boolean wonornot()
	{
		boolean declaration;
		declaration = gotprize;
		if(gotprize == true)
		{
			timeswon++;
			if(didswitch)
				timeswonbyswitch++;
		}
		return declaration;
	}
	/**
	 * method that draws out number of doors and numbers them
	 * @param numofdoors number of doors to draw
	 */
	public void drawdoors( int numofdoors)
	{
		for(int i = 0; i < numofdoors; i++)
		{
			for(int j = 0; j < 10; j++)
				System.out.print("=");
			System.out.print(" \t");
		
			if(i == 2)
				System.out.println();
		}
		for( int k = 0; k < 6; k++)
		{
			for(int i2 = 0; i2 < numofdoors; i2++)
			{			
				int doornum = i2 + 1;
				if(k == 3)
					System.out.print("H   " + doornum + "    H \t");
				else
					System.out.print("H        H \t");
			}
			System.out.print("\n");
		}
		for( int i3 = 0; i3 < numofdoors; i3++)
		{
			for(int m = 0; m < 10; m++)
				System.out.print("=");
			System.out.print(" \t");
		}
		System.out.println();
	}
	public void getStats()
	{
		System.out.println();
		System.out.println();
		System.out.println("times played: " + timesplayed);
		System.out.println("Times won: " + timeswon );
		System.out.println("times won by switching: " + timeswonbyswitch);
		System.out.println("times won by keeping: " + (timeswon - timeswonbyswitch));
		
		double percentwonbyswitch = 100 * (double)timeswonbyswitch / timeswon;
		System.out.println("won " + percentwonbyswitch + " percent times won by switching!");
		
		System.out.println("won " + (100 - percentwonbyswitch) + " percent times won by keeping!");
		int timeskept = timesplayed - timesswitched;
		System.out.println("Times kept: " + timeskept );
		System.out.println("Times switched: " + timesswitched );
			
	}
}