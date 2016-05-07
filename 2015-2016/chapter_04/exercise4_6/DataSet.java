package exercise4_6;

public class DataSet {


	int num1, num2, num3, num4, min, max;
	
	/**
	 * Class Constructor
	 * @param n1	first number entered
	 * @param n2	second number entered
	 * @param n3	third number entered
	 * @param n4	fourth number entered
	 */
	public DataSet( int n1, int n2, int n3, int n4)
	{
		num1 = n1;
		num2 = n2;
		num3 = n3;
		num4 = n4;
		min = Math.min(n1, n2);
		min = Math.min(min, n3);
		min = Math.min(min, n4);
		
		max = Math.max(n1, n2);
		max = Math.max( max, n3);
		max = Math.max(max, n4);
	}
	
	/**
	 * method that adds a value and updates min/max
	 * @param x	the value that gets added
	 */
	public void addValue( int x )
	{
		min = Math.min(min, x);
		max = Math.max(max, x);
	}
	
	/**
	 * returns the max value
	 * @return	the max value
	 */
	public int getLargest()
	{
		return max;
	}
	
	/**
	 * returns minimum value
	 * @return	the minimum value
	 */
	public int getSmallest()
	{
		return min;
	}
}
