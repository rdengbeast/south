package p_exercise3_6;

public class Exercise3_6tester {

	public static void main(String [] args)
	{
		Car myCar = new Car();
		myCar.addGas(31);
		myCar.drive(300);
		System.out.println( myCar.getGas() );
	}
}
