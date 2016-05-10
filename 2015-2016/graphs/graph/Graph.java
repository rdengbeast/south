package graph;

import java.util.Map;
import java.util.TreeMap;

public class Graph
{
	private TreeMap<String, String> map;
	private boolean yahOrNay;
	private int shortest;
	private String x;

	public Graph(String line)
	{
		map = new TreeMap<String, String>();
		String[] x = line.split(" ");
		for(String s : x)
		{
			if(!map.containsKey(s.substring(0, 1)))
				map.put(s.substring(0, 1), s.substring(1, 2));
			else
				map.put(s.substring(0, 1), map.get(s.substring(0, 1)) + s.substring(1, 2) );
			if(!map.containsKey(s.substring(1, 2)))
				map.put(s.substring(1, 2), s.substring(0, 1));
			else
				map.put(s.substring(1, 2), map.get(s.substring(1, 2)) + s.substring(0, 1) );

		}
		
	}

	public int contains(String letter)
	{
		shortest = 0;
		x = "";
		check(letter.substring(0, 1), letter.substring(1, 2), "", 0, letter.substring(0, 1));
		return shortest;
//		return yahOrNay;
	}

	public String steps()
	{
		return x;
	}
	public boolean has()
	{
		return yahOrNay;
	}
	public void check(String first, String second, String placesUsed, int steps, String t)
	{
		String trail = map.get(first);
		yahOrNay = false;
		if(trail.indexOf(second) >= 0)
		{
			yahOrNay = true;
			shortest = steps + 1;
			x = t + second;
//			return steps + 1;
		}
		else
		{
			for(int i = 0; i < trail.length(); i++)
			{
				String nextletter = trail.substring(i, i + 1);
				if( !placesUsed.contains(nextletter) )//placesUsed.indexOf(nextletter) < 0)
				{
					placesUsed += first;
					check(nextletter, second, placesUsed, steps + 1, t + nextletter);					
				}
			}
		}
	}

	public String toString()
	{
		String output = "";
		for(String s : map.keySet() )
			output += s + "-" + map.get(s) + " ";
		return output;
	}
}