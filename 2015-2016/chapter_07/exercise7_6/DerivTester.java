package exercise7_6;
import java.util.Scanner;

public class DerivTester {

	public static void main(String [] args)
	{
		System.out.println("Enter numbers. When done, type enter.");
		Scanner in = new Scanner(System.in);
		DataSet s1 = new DataSet();
		float [] inputs = {};
		while(in.hasNextFloat())
		{	
			float inputfloat = in.nextFloat();
			s1.update(inputfloat);
			
			float [] inputstemp = inputs;
			inputs = new float[inputstemp.length + 1];
			for(int i = 0; i < inputstemp.length; i++)
				inputs[i] = inputstemp[i];
			inputs[inputstemp.length] = inputfloat;
		}
		for(int i = 0; i < inputs.length; i++)
			System.out.print(inputs[i] + " " );
		System.out.println();
		System.out.println("count: " + s1.getCount());
		System.out.println("average: " +s1.average());
		System.out.println("standard derivation: " + s1.deriv());
		in.close();
	}
}
