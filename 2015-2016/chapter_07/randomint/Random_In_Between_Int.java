package randomint;

public class Random_In_Between_Int {

	private int a;
	private int b;
	private int intinbetween;
	public Random_In_Between_Int(int start, int end)
	{
		a = start;
		b = end;
	}
	public int inbetweenint()
	{
		intinbetween = b - (int)( Math.random() * (b + 1 - a) );
		return intinbetween;
	}
}
