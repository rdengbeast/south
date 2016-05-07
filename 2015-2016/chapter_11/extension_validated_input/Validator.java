package extension_validated_input;

public interface Validator<E>
{
	String prompt();
	String error();
	
	boolean isValid(String value);
}
