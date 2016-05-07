package exercise4_5;

public class DataSetTester {

	/**
	 * method to test the DataSet class
	 */
	public static void main( String [] args)
	{
		DataSet d1 = new DataSet( 1, 2, 4, 5);
		d1.addValue(3);
		d1.addValue(6);
		d1.addValue(7);
		d1.addValue(100);
		System.out.println(d1.getSum());
		System.out.println(d1.getAverage());
	}
}
