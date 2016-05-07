package exercise11_3;

public class Person implements Measurable {

	public String name;
	public int height; //in centimeters
	
	public Person(String n, int h)
	{
		name = n;
		height = h;
	}
	
	public String getName()
	{
		return name;
	}
	public int getHeight()
	{
		return height;
	}
	public double getMeasure()
	{
		return height;
	}
}
