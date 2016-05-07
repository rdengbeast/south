package p18_4;

public class Sentence {

	private String sentence;
	public Sentence(String s)
	{
		sentence = s;
	}
	public boolean find(String t)
	{
		if(t.length() < sentence.length())
			return false;
		return(t.equals(sentence.substring(0, t.length()) ) || new Sentence(sentence.substring(1)).find(t) );

	}
}
