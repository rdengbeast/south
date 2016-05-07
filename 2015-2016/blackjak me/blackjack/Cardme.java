package blackjack;

public class Cardme {

	private char suit;
	private char name;
	private int val;
	
	public Cardme(char n, int v, char suit)
	{
		name = n;
		val = v;
		this.suit = suit;
	}
	
	public char getName()
	{
		return name;
	}
	public int getVal()
	{
		return val;
	}
	
	public String toString()
	{
		return "" + name + " of " + suit;
	}
}
