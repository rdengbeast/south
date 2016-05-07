package exercise8_2thru8_6;

import java.util.ArrayList;

public class Purse {

	private ArrayList<String> p1 = new ArrayList();
	
	/**
	 * adds a coin to purse
	 * @param coinName name of the coin
	 */
	public void addCoin(String coinName)
	{
		p1.add(coinName);
	}
	
	/**
	 * returns arraylist, which is the "purse" with the coins in it
	 * @return arraylist with coins in it
	 */
	public ArrayList<String> getArrayList()
	{
		return p1;
	}
	
	/**
	 * toString method for purse class, for when purse is treated like a string
	 */
	public String toString()
	{
		String purse = "Purse[" ;
		
		for(int i = 0; i < p1.size()-1; i++)
			purse += (p1.get(i) + ",");
		
		purse += (p1.get(p1.size() - 1)  + "]" );
		
		return purse;
	}
	
	/**
	 * reverses order of coins in purse
	 */
	public void reverse()
	{
		ArrayList<String> temp = new ArrayList();
		for(int i = 0; i < p1.size(); i++ )
			temp.add( p1.get(p1.size() - 1 - i) );
		p1 = temp;
	}
	
	/**
	 * transfers contents of one purse into another
	 * @param other the other purse
	 */
	public void transfer(Purse other)
	{
		ArrayList<String> temp = other.getArrayList();
		for(int i = 0; i < temp.size(); i++)
			p1.add(temp.get(i));
	}
	
	/**
	 * checks whether the two purses have the same contents, order of coins matter
	 * @param other other purse
	 * @return t/f of whether they contain same contents
	 */
	public boolean sameContents(Purse other)
	{
		boolean hassamecontents = false;
		
		if(p1.equals( other.getArrayList() ) )
			hassamecontents = true;
		
		return hassamecontents;
	}

	/**
	 * checks whether the purses contain the same coins (order doesn't matter)
	 * @param other	the other purse
	 * @return	t/f of whether the purses contain the same coins
	 */
	public boolean sameCoins(Purse other)
	{
		boolean hassamecoins = true;
		
		ArrayList<String> temp = other.getArrayList();
		
		for(int i = 0; i < 4; i++)
		{
			if(coinsort(p1)[i] != coinsort(temp)[i] )
				hassamecoins = false;
		}
		
		return hassamecoins;
	}
	
	/**
	 * sorts coins into an array that keeps track of how many coins there are
	 * @param purse	purse to be sorted
	 * @return	array containing ints of numbers of each coin[quarter, dime, nickel, penny]
	 */
	public int[] coinsort( ArrayList<String>purse)
	{
		int[] coins= new int[4];
		for(int i = 0; i < purse.size(); i++)
		{
			switch(purse.get(i) )
			{
			case "quarter":
				coins[0]++;
				break;
			case "dime":
				coins[1]++;
				break;
			case "nickel":
				coins[2]++;
				break;
			case"penny":
				coins[3]++;
				break;
			}
		}
		return coins;
	}
}
