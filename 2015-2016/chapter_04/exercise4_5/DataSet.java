package exercise4_5;

public class DataSet 
{
	int num1, num2, num3, num4, sum, count;
	
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
		sum = num1 + num2 + num3 + num4;
		count = 4;
	}
	
	/** a method to add a value
	 * @param	x	int to add
	 * @return nothing
	 */
	public void addValue( int x)
	{
		sum = sum + x;
		count++;
	}
	
	/**
	 * method to get sum of integers
	 * @return	sum of the integers
	 */
	public int getSum()
	{
		return sum;
	}
	
	/**
	 * method to get average of integers
	 * @return	the average of the integers
	 */
	public double getAverage()
	{
		double average = sum/count;
		return average;
	}
}
