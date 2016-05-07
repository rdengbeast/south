package exercise13_5;

public class Executive extends Manager{

	public Executive(String name, double sal, String dep, String niceclothes)
	{
		super(name, sal, dep);
		niceClothes = niceclothes;
		// TODO Auto-generated constructor stub
	}

	private String niceClothes;
	
	public String toString()
	{
		return super.toString() + ", " + niceClothes;
	}
}
