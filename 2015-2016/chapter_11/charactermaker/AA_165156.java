package charactermaker;

public class AA_165156 implements CharacterMaker {

	private char[] chararray = {'A', 'I', 's', 'o', '!'};
	
	@Override
	/**
	 * returns char 10 by 10 array representing ascii version of passed in  char
	 * returns null if not supported
	 */
	public char[][] characterToAscii(char character) 
	{
		String[] ascii = {
				"                        __       ()()     ()  ()   ()====() ()      ()                              ",
				"                      ======      ) )      ( (        ) )      ( (      ======                      ",
				"          $$$$ZZZ$$$$$$$    $$$$$  (__$$$$$$   $$$$$  $   $$$$   $   $$$$     $$$$$ZZZZZ$$          ",
				"            oooooo   oooooooo oooo  ooooooo    oooooo    ooooooo  oooo oooooooo   oooooo            ",
				"             ___      |||||     |||||      Y|Y       |||        Y         |        (O)              "				
			};
		
		if(characterSupported(character) )
		{
			for(int i = 0; i < 5; i ++)
			{
				if(character == chararray[i])
				{
					char[][] asciicharacter = new char[10][];
					
					for(int j = 0; j < 100; j++)
						if(( j + 1 ) % 10 == 0 )
							asciicharacter[j / 10] = ascii[i].substring(j - 9, j + 1).toCharArray();
					return asciicharacter;
				}
			}
		}
		return null;
	}

	/**
	 * returns whether a character is supported or not
	 */
	public boolean characterSupported(char character) 
	{
		// TODO Auto-generated method stub
		for(char supportedchar : chararray)
		{
			if(supportedchar == character)
				return true;
		}
		return false;
	}

	@Override
	/**
	 * returns a char array of supported characters
	 */
	public char[] supportedCharacters() 
	{
		// TODO Auto-generated method stub
		return chararray;
	}

	/**
	 * returns all the chars supported in ascii form
	 */
	public String toString()
	{
		String x = "";
		for( char character : chararray)
		{
			for(int i = 0; i < 10; i++)
			{
				for(char c : characterToAscii(character)[i] )
					x += Character.toString(c);
				x += "\n";
			}
		}
		return x;
	}

}
