package exercise3_13;

public class RabbitPopulation {
	private int newrabbits; //pairs of rabbbits!!!
	private int oldrabbits;
	
	public RabbitPopulation()
	{
		newrabbits = 1;
		oldrabbits = 0;
	}
	public void waitamonth()
	{
		int temp = oldrabbits;
		oldrabbits = newrabbits + oldrabbits;
		newrabbits = newrabbits + temp;
	}
	public int getPairs()
	{
		int totalpairs = oldrabbits + newrabbits;
		return totalpairs;
	}
}
