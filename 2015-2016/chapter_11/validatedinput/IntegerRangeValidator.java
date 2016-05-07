package validatedinput;

public class IntegerRangeValidator implements Validator
{
	private int max;
	private int min;
	
	public IntegerRangeValidator(int minimum, int maximum)
	{
		max = maximum;
		min = minimum;
	}
	public String error()
	{
		return "Input is not a valid integer.";
	}

	public String prompt()
	{
		return "Enter an integer between the intervals given.";
	}

	public boolean isValid(String value)
	{
		AnyIntegerValidator intvalid = new AnyIntegerValidator();
		if(intvalid.isValid(value))
		{
			int newint = Integer.parseInt(value);
			return (newint >= min && newint <= max);
		}
		else
			return false;
	}
}
