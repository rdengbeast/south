package validatedinput;

import java.util.Scanner;

public class ValidatedInput
{
	private Scanner scan = new Scanner(System.in);;
	
	// prompt is validator.prompt(), error on invalid input is validator.error()
	// validity check is validator.isValid(...)
	// continues prompting and displaying error until valid input is obtained
	// returns valid input
	public int getInt(Validator<Integer> validator)
	{		
		return Integer.parseInt(validateStuff(validator, 0, false)); // TODO: implement method
	}
	
	// same as above
	// accepts any integer as valid input
	// hint: use AnyIntegerValidator with the above method
	public int getInt()
	{
		AnyIntegerValidator a1 = new AnyIntegerValidator();
		return getInt(a1);
		// TODO: implement method
	}

	// same as above
	// accepts any integer x such that: min <= x <= max
	// precondition: min <= max
	// hint: define a class IntegerRangeValidator to use with the first method
	public int getInt(int min, int max)
	{
		IntegerRangeValidator i1 = new IntegerRangeValidator(min, max);
		return getInt(i1); // TODO: implement method
	}
	
	public int getInt(char c)
	{
		EvenOddValidator e1 = new EvenOddValidator(c);
		return getInt(e1);
	}
	
//	public boolean isValidPassword(Validator<String> validator, int limit)
//	{
//		return validateStuff(validator, limit, true) != null;
//	}
//	
//	public boolean tryPassword(int limit)
//	{
//		SimplePasswordValidator s1 = new SimplePasswordValidator();
//		return isValidPassword(s1, limit);
//	}
	
	private String validateStuff(Validator validator, int limit, boolean limitneeded)
	{
		int timestried = 0;
		
		while(timestried < limit || !limitneeded)
		{
			System.out.println(validator.prompt());
			String input = scan.next();
			if(validator.isValid(input) )
				return input;
			else
			{
				System.out.println(validator.error() );
				timestried++;
			}
		}
		return null;
	}
}
