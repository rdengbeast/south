package exercise4_12;

public class DigitExtractor {

	int Integer;
	
	public DigitExtractor(int anInteger)
	{
		Integer = anInteger;
		
	}
	public int nextDigit()
	{
		int x = Integer % 10;
		Integer = Integer / 10;
		return x;
	}
}
