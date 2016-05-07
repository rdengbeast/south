package exercise11_1;

public class DieMeasureTester {

	public static void main(String[] args){
		
		DataSet die = new DataSet();
		Die d1 = new Die(6);
		Die d2 = new Die(6);
		d1.cast();
		d2.cast();
		die.add(d1);
		die.add(d2);
		System.out.println(die.getAverage());
	}
}
