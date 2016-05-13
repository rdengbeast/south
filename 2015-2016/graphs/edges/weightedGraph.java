package edges;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class weightedGraph 
{
	private TreeMap<String, Set<Edge> > map;
	int ch, qu, cl;
	private Set<Edge> cheapest;
	private Set<Edge> quickest;
	private Set<Edge> closest;
	
	public weightedGraph()
	{
		map = new TreeMap<String, Set<Edge>>();
		cheapest = new HashSet<Edge>();
		quickest = new HashSet<Edge>();
		closest = new HashSet<Edge>();
		ch = Integer.MAX_VALUE;
		qu = Integer.MAX_VALUE;
		cl = Integer.MAX_VALUE;
	}
	
	public String toString()
	{
		String output = "";
		for(String s : map.keySet())
		{
			output += s + "-";
			for(Edge e : map.get(s))
				output += e.getEnd();
			output += " ";
		}
		return output;
	}
	public void addData(String line)
	{
		String[] s = line.split(" ");
		Edge ej = new Edge( s[0].substring(0, 1), s[0].substring(1, 2), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
		Edge ej2 = new Edge( s[0].substring(1,2), s[0].substring(0, 1), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
		newEdge( ej);
		newEdge( ej2);
	}
	private void newEdge( Edge ej)
	{
		Set<Edge> s = new HashSet<Edge>();
		s.add(ej);
		if(map.containsKey(ej.getStart()))
			((Set)(map.get(ej.getStart()))).add(ej);
		else
			map.put(ej.getStart(), s);
	}
	
	//===================================================
	
	public void check(Set<Edge>s)
	{
		String output = "";
		for(Edge e : s)
			output += e.getStart() + e.getEnd() + " ";
		System.out.println("checking " + output);

		
		int temp = 0;
		for(Edge e : s)
			temp += e.getDistance();
		if(temp < cl)
		{
			cl = temp;
			closest = s;
		}
		
		temp = 0;
		for(Edge e : s)
			temp += e.getCost();
		if(temp < ch)
		{
			ch = temp;
			cheapest = s;
		}
		
		temp = 0;
		for(Edge e : s)
			temp += (e.getDistance() / e.getSpeed()); 
		if(temp < qu)
		{
			qu = temp;
			quickest = s;
		}
	}
	
	public void getPaths(String start, String end, Set<Edge> trail, String beento)
	{
		if(start.equals(end))
			check(trail);
		
		else
		{
			Set<Edge>temp;

			for(Edge e : map.get(start))
				if(!beento.contains(e.getEnd()))
				{
					temp = new HashSet<Edge>();
					for(Edge x : trail)
						temp.add(x);
					
					temp.add(e);
					getPaths(e.getEnd(), end, temp, beento + start);
				}
		}
	}

	public String quickest()
	{
		String output = "";
		for(Edge e : quickest)
			output += e.getStart() + e.getEnd() + " ";
		return output + "in " + qu + " time";
	}
	public String closest()
	{
		String output = "";
		for(Edge e : closest)
			output += e.getStart() + e.getEnd() + " ";
		return output + "distance: " + cl;
	}
	public String cheapest()
	{
		String output = "";
		for(Edge e : cheapest)
			output += e.getStart() + e.getEnd() + " ";
		return output + "costs " + ch;
	}
}
