package exercise4_6;

public class DataSetTester {

	public static void main( String [] args)
	{
		DataSet d1 = new DataSet( 1, 2, 3, 4);
		d1.addValue(5);
		d1.addValue(6);
		d1.addValue(7);
		d1.addValue(8);
		d1.addValue(101);
		System.out.println(d1.getLargest());
		System.out.println(d1.getSmallest());
	}
}
