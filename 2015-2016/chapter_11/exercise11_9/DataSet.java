package exercise11_9;

//import shared.Measurable;

/**
 * Computes the average of a set of data values.
 */
public class DataSet
{
//	private double sum;
	
	private Comparable c1;
	private Comparable maximum;
	private Comparable minimum;

	//	private int count;

	/**
	 * Constructs an empty data set.
	 */
	public DataSet()
	{
		c1 = null;
		minimum = null;
		maximum = null;
	}

	/**
	 * Adds a data value to the data set.
	 * 
	 * @param x
	 *            a data value
	 */
	public void add(Comparable x)
	{
		if (maximum == null || x.compareTo(maximum) > 0)
			maximum = x;
		if (minimum == null || x.compareTo(minimum) < 0)
			minimum = x;
	}

	/**
	 * Gets the average of the added data.
	 * 
	 * @return the average or 0 if no data has been added
	 */
//	public double getAverage()
//	{
//		if (count == 0)
//			return 0;
//		else
//			return sum / count;
//	}

	/**
	 * Gets the largest of the added data.
	 * 
	 * @return the maximum or 0 if no data has been added
	 */
	public Comparable getMaximum()
	{
		return maximum;
	}
	public Comparable getMinimum()
	{
		return minimum;
	}
}