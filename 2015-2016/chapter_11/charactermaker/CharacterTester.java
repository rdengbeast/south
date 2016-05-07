package charactermaker;

public class CharacterTester {

	public static void main(String [] args)
	{
		CharacterMaker a1 = new AA_165156();
		char[] chararray = args[0].toCharArray();
		
		String horizontal = "";

		System.out.println("chars supported: ");
		for(char c : a1.supportedCharacters() )
			System.out.print(c);
		
		for(int i = 0; i < 10; i++)
		{
			for(char character : chararray)
			{
				if(a1.characterSupported(character))
				{
					for(char c : a1.characterToAscii(character)[i] )
						horizontal += Character.toString(c);
					horizontal += " ";
				}
			}
			horizontal += "\n";
		}
		System.out.println(horizontal);
		

		
//		System.out.println(a1.toString());
	}
}
