package morse;

public class MorseCode extends BalancedTree
{
	
	public MorseCode(Morse[] data)
	{
		super(data);
//		inOrder();
	}
	public String toMorse(String english)
	{
		String rosetta = "0-9O. 8M Q G Z7T Y K C N X D B6/1J W P A   R L E2- U F I3V S4H5";
		String output = "";
		int index = 0;
		for(int i = 0; i < english.length(); i++)
		{
			if(english.charAt(i) == ' ')
				output += "/";
			else
			{
				index = rosetta.indexOf(english.substring(i, i + 1));
				output += search(index) + " ";
			}
		}
		return output;
	}
	public String search(int i)
	{
		return search(root, i);
	}
	private String search(TreeNode tree, int i)
	{
		if(tree == null)
			return "";
		if( ((Morse)tree.getValue()).getIndex() == i)
			return "";
//			return ((Morse)(tree.getValue())).getLetter();
		if( ((Morse)tree.getValue()).getIndex() - i < 0)
			return "." + search(tree.getRight(), i);
		return "-" + search(tree.getLeft(), i);
	}
	
	public String toEnglish(String morse)
	{
		String output = "";
		TreeNode current = getRoot();
		System.out.println("root: " + getRoot());
		for(int i = 0; i < morse.length(); i++)
		{
			if(morse.charAt(i) == '-')
				current = current.getLeft();
			else if(morse.charAt(i) == '.')
				current = current.getRight();
			else if(morse.charAt(i) == '/')
			{
				output += ((Morse)current.getValue()).getLetter() + " ";
				current = getRoot();
			}
			else if(morse.charAt(i) == ' ')
			{
				output += ((Morse)current.getValue()).getLetter();
				current = getRoot();
			}

		}
				
		return output;
		
	}

	public static void main(String[] args)
	{
		String code = "0-9O. 8M Q G Z7T Y K C N X D B6/1J W P A   R L E2- U F I3V S4H5";
		String engrish = "MY FEET SMELL AND MY NOSE RUN";
		String mohorse = "-- -.--/..-. . . -/... -- . .-.. .-../.- -. -../-- -.--/-. --- ... ./.-. ..- -.";
		String mohorse1 = "-- -.-- /..-. . . - /... -- . .-.. .-.. /.- -. -.. /-- -.-- /-. --- ... . /.-. ..- -.";
		Morse[] m = new Morse[63];
		for(int i = 0; i < code.length(); i++)
		{
			m[i] = new Morse(i, code.substring(i, i + 1));
		}
		for(Morse yes : m)
			System.out.print(yes);
		MorseCode mc = new MorseCode(m);
		System.out.println("hello");
		System.out.println(mc.toEnglish(mohorse));
		System.out.println(mc.toMorse(engrish) );
		System.out.println(mc.toEnglish(mohorse1));
		

	}
}
