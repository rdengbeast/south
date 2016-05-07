package p18_9;

import java.util.ArrayList;

public class SubstringGenerator
{
	public static void main(String[] args)
	{
		System.out.println( getSubstrings("booty") );
	}

	public static ArrayList<String> getSubstrings(String x)
	{
		return(getSubstrings(x, 0));
	}
	private static ArrayList<String> getSubstrings(String x, int index)
	{
		if(index == x.length())
			return new ArrayList<String>();
		
		ArrayList<String> substrings =  getSubstrings(x, index + 1);
		
		int size = substrings.size();
		
		for(int i = size - 1; i >= size - (x.length() - 1 - index) ; i--)
			substrings.add(x.charAt(index) + substrings.get(i));
		substrings.add("" + x.charAt(index));
		return substrings;
	}
	
}