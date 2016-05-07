package exercise7_3;

public class CannonvertTester {

	private static final double tolerance = 0.01;

	public static void main(String [] args)
	{
		double initv = 75;
		Cannonvert v1 = new Cannonvert(initv);
		int millispassed = 0;
		double pos = v1.getPos();
		while(pos >= 0 )
		{
			if( millispassed % 100 == 0 )
			{
				System.out.println();
				System.out.println("time: " + millispassed / 100.0);
				System.out.println("predicted: " + v1.getCalcPos( millispassed / 100.0, initv));
				System.out.println("actual: " + pos);
			}			
			v1.update();			
			pos = v1.getPos();

			millispassed++;
		}
		
		System.out.println();
		System.out.println(millispassed / 100.0);
		System.out.println("predicted: " + v1.getCalcPos( millispassed / 100.0, initv));
		System.out.println("actual: " + pos);
	}
	
}
