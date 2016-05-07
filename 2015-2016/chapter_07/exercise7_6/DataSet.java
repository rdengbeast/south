package exercise7_6;

public class DataSet {
	
	private float sum;
	private float sumofsquares;
	private int count;
	
	public DataSet()
	{
		sum = 0;
		sumofsquares = 0;
		count = 0;
	}
	
	/**
	 * updates instance fields with latest input
	 * @param latest
	 */
	public void update(float latest)
	{
		sum += latest;
		sumofsquares += Math.pow(latest, 2);
		count++;
	}
	
	/**
	 * gets number of total entries
	 * @return number of total entries
	 */
	public int getCount()
	{
		return count;
	}
	/**
	 * calculates average
	 * @return average
	 */
	public double average()
	{
		return( sum / count );
	}
	/**
	 * finds standard deviation of entries
	 * @return deviation of entries
	 */
	public double deriv()
	{
		double derivation = Math.sqrt( ( sumofsquares - Math.pow(sum, 2) / count ) / (count - 1) );
		return derivation;
	}
	
}
