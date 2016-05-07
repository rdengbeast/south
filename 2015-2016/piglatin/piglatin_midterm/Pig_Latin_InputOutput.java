package piglatin_midterm;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * program that translates whatever you input into pig latin! :)
 * @author Richard
 *
 */
public class Pig_Latin_InputOutput {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("This a translater from english to pig latin.(Start? y/n )");
		
		String englishphrase = new String();
				
		ArrayList<String> piglatinwords = new ArrayList<String>();

		while( in.nextLine().equals("y") )
		{
			
			System.out.println("enter english, then press <ENTER>");
			
			englishphrase = in.nextLine();

			piglatinwords = Pig_Latin_Translater.translateString(englishphrase);
			
			for(String piglatinword : piglatinwords)
			{
				System.out.print( piglatinword );
			}
			
			System.out.println();
			System.out.println("Enter another? press y or n");
			
		}
		
		in.close();
		System.out.println("done");
	}

}
