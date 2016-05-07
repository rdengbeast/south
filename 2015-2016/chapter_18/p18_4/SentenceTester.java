package p18_4;

public class SentenceTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(find("halleljjaskdfjs lsjflsjflj", "hal"));
	}

	public static boolean find(String tosearch, String tofind)
	{
		if(tosearch.length() == 0)
			return false; 
		if(tosearch.startsWith(tofind))
			return true;
		else
			return find(tosearch.substring(1), tofind );
	}
}
