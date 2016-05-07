package extension_validated_input;

public class Tester
{
	public static void main(String[] args)
	{
		ValidatedInput vi = new ValidatedInput();

		// get any integer
		int any = vi.getInt();
		System.out.println("User entered: " + any);
		
		// get integer x such that: 10 <= x <= 50
		int x = vi.getInt(10, 50);
		System.out.println("User entered: " + x);
		
		// TODO: make a new implementation of validator that validates
		//		 input with your choice of criteria (ex: divisible by
		//		 a specified number. Use it to test the method below.
		
		int mine = vi.getInt('e');
		System.out.println("User entered: " + mine);
		
		if(vi.tryPassword(4))
			System.out.println("unlocked!");
		else
			System.out.println("too many tries");
	}
}