package exercise11_3;

public class PersonProcessor {

	public static void main(String[] args)
	{
		DataSet people = new DataSet();
		Person p1 = new Person("ray", 160);
		Person p2 = new Person("carl", 180);
		people.add(p1);
		people.add(p2);
		System.out.println("average: " + people.getAverage() );
		System.out.println("max: " + ( (Person)people.getMaximum() ).getName() );
	}
}
