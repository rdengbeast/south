package p18_10;

import java.util.ArrayList;

public class SubsetGenerator
{

	public static void main(String[] args)
	{
		System.out.println( getSubsets("poop") );
	}
	
	public static ArrayList<String> getSubsets(String x)
	{
		return(getSubsets(x, 0));
	}
	private static ArrayList<String> getSubsets(String x, int index)
	{
		if(index == x.length())
			return new ArrayList<String>();
		
		ArrayList<String> subsets =  getSubsets(x, index + 1);
		
		int size = subsets.size();
		
		for(int i = 0; i < size; i++)
			subsets.add(x.charAt(index) + subsets.get(i));
		subsets.add("" + x.charAt(index));
		return subsets;
	}
	
}