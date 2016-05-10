package morse;

public class Morse implements Comparable
{

	int index;
	String letter;
	public Morse(int a, String b)
	{
		index = a;
		letter = b;
	}
	
	@Override
	public int compareTo(Object arg0) 
	{
		
		return index;
	}

	public String getLetter() 
	{
		// TODO Auto-generated method stub
		return letter;
	}
	public int getIndex()
	{
		return index;
	}

	public String toString()
	{
		return getLetter();
	}
}
