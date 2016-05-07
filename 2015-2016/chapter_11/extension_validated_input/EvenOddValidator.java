package extension_validated_input;

public class EvenOddValidator implements Validator
{
	private int remainder;
	
	public EvenOddValidator(char c)
	{
		if(c == 'e')
			remainder = 0;
		else
			remainder = 1;
	}
	public String error()
	{
		return "Input is not a valid integer.";
	}

	public String prompt()
	{
		return "Enter an integer that is even";
	}

	public boolean isValid(String value)
	{
		AnyIntegerValidator a2 = new AnyIntegerValidator();
		if(a2.isValid(value))
		{
			int newint = Integer.parseInt(value);
			return (newint % 2) == remainder;
		}
		else
			return false;
	}
}
