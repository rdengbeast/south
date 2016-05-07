package piglatin_midterm;

import java.util.ArrayList;

public class Pig_Latin_Translater {

	/**
	 * translates an english word into pig latin
	 * @param englishword english word to be translated
	 * @return pig latin translation
	 */
	public String translate( String englishword )
	{
		String piglatinword = new String();
		
		if( getfirstvowelindex( englishword ) == englishword.length() )
		{
			piglatinword = englishword + "ay";
		}
		else if( hasvowelat(englishword, 0))
		{
			piglatinword = englishword + "yay";
		}
		else
		{
			int firstvowelposition = getfirstvowelindex(englishword);
			piglatinword = englishword.substring(firstvowelposition) +  englishword.substring(0,  firstvowelposition) + "ay";
			
			if(Character.isUpperCase(englishword.charAt(0) ) )
				piglatinword = Character.toUpperCase(piglatinword.charAt(0)) + piglatinword.substring(1).toLowerCase();
				
		}
		return piglatinword;
	}

	/**
	 * returns index of first vowel in the word
	 * @param word, inputted word
	 * @return index of first vowel in the word
	 */
	public int getfirstvowelindex(String word)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(hasvowelat(word, i))
				return i;
		}
		return word.length();
	}
	
	/**
	 * Runs through word to see if there are any vowels in the word at index
	 * @param word the word that is inputted
	 * @param index the indicated index
	 * @return
	 */
	public boolean hasvowelat(String word, int index)
	{
		switch( word.charAt(index) )
		{
			case 'a':
				return true;
			case 'A':
				return true;
			case 'e':
				return true;
			case 'E':
				return true;
			case 'i':
				return true;
			case 'I':
				return true;
			case 'o':
				return true;
			case 'O':
				return true;
			case 'u':
				return true;
			case 'U':
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * method to actually call the translate method, used to save above code from repeating
	 * @param s, string in english to translate
	 * @return above string in piglatin
	 */
	public static ArrayList<String> translateString(String s)
	{
		Pig_Latin_Translater pl = new Pig_Latin_Translater();
		
		ArrayList<String> newstring = new ArrayList<String>();
		int nextwordstart = 0;
		char[] symbols = {'!', '?', ' ', ',', '.', ':', ';', '-', '(', ')', '"'};
		
		for(int i = 0; i < s.length(); i++)
		{
			for(int j = 0; j < symbols.length; j++)
			{
				if(s.charAt(i) == symbols[j] )
				{
					if(i != nextwordstart)
						newstring.add(pl.translate(s.substring(nextwordstart, i)) );
					
					nextwordstart = i + 1;
					newstring.add( String.valueOf( symbols[j]) );

				}
			}
		}
		
		if(nextwordstart != s.length() )
			newstring.add(pl.translate(s.substring(nextwordstart, s.length() ) ) );
		
		newstring.trimToSize();
		return newstring;
	}
}
