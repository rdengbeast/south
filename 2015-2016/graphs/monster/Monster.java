package monster;

public class Monster implements Comparable 
{
	int height, weight, age;
	
	public Monster(int h, int w, int a) 
	{
		height = h;
		weight = w;
		age = a;
	}

	public int getHeight()
	{
		return height;
	}
	public int getWeight()
	{
		return weight;
	}
	public int getAge()
	{
		return age;
	}
	
	public int compareTo(Object arg0) 
	{
		// TODO Auto-generated method stub
		Monster other = (Monster)arg0;
		if(height != other.getHeight())
			return height - other.getHeight();
		if(weight != other.getWeight())
			return weight - other.getWeight();
		if(age != other.getAge())
			return age - other.getAge();
		
		return 0;
		
	}
	public String toString()
	{
		String output = "";

			output += height + " " + weight + " " + age;
		return output;
	}
}
