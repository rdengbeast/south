package edges;

public class Edge implements Comparable
{
	private String start;
	private String end;
	private int speed, distance, cost;

	public Edge( String start, String end, int speed, int distance, int cost)
	{
		this.start = start;
		this.end = end;
		this.speed = speed;
		this.distance = distance;
		this.cost = cost;
	}

	public String getStart()
	{	
		return start;
	}

	public String getEnd()
	{
		return end;
	}

	public int getSpeed()
	{
		return speed;
	}

	public int getDistance() 
	{
		return distance;
	}

	public int getCost() 
	{
		return cost;
	}

	@Override
	public int compareTo(Object arg0) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
