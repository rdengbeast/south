package extension_validated_input;

public class SimplePasswordValidator implements Validator
{

	private String password = "mrhorn";

	public String prompt() 
	{
		// TODO Auto-generated method stub
		return "enter password please";
	}

	public String error() 
	{
		// TODO Auto-generated method stub
		return "wrong password";
	}

	public boolean isValid(String value) 
	{
		// TODO Auto-generated method stub
		return value.equals(password);
	}
	
}
