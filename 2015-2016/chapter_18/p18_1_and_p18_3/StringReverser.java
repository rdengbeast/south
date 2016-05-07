package p18_1_and_p18_3;

public class StringReverser
{
	public static void main(String[] args)
	{
	    System.out.println(reverse("watsup"));
	    System.out.println(reverseIteratively("watsup"));
	}
	
	public static String reverse(String toReverse)
	{
		if(toReverse.length() == 0)
			return "";
		return toReverse.substring(toReverse.length() - 1) + reverse(toReverse.substring(0, toReverse.length() - 1));
	}
	
	public static String reverseIteratively(String toReverse)
	{
		String newstring = "";
		for(int i = 0; i < toReverse.length(); i ++)
			newstring += toReverse.charAt(toReverse.length() - 1 - i);
		return newstring;
	}
}