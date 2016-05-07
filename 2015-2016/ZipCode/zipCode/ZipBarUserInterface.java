package zipCode;
import java.util.Scanner;
/**
 * interacts with user, asks for input, prints out barcode or zipcode
 * asks what you want to enter: barcode or zipcode
 * once something entered, the conversion is outputted
 * asks whether you want to do it again, y/n
 * 
 * @author 165156
 *
 */
public class ZipBarUserInterface {
	
	static Scanner in = new Scanner(System.in);
	
	/**
	 * static method that asks for whether user wants to repeat action
	 * while user says "yes", program will ask for input again
	 */
	public static void takeInput()
	{
		welcomeMessage();
		do {
			askbarorzip();
		} while (askforanother());
		
	}
	
	/**
	 * prints a welcome message
	 */
	public static void welcomeMessage()
	{
		System.out.println("Hello! Welcome to barcode/zip / zip/barcode converter!");
	}
	
	/**
	 * takes in a bar and prints the zip code conversion of it
	 */
	public static void askbarorzip()
	{
		System.out.println("Would you like to enter a barcode or a zipcode? (B/Z)");
		String barOrZip = in.nextLine();
		if(barOrZip.equalsIgnoreCase("B") )
		{
			System.out.println("enter barcode");
			getBarandconvert(in.nextLine() );
		}
		else if(barOrZip.equalsIgnoreCase("Z"))
		{
			System.out.println("enter zipcode");
			getZipandconvert( Integer.parseInt( in.nextLine() ) );
		}
	}
	
	/**
	 * asks whether you want to enter something again
	 * @return whether the user enters "y" or not
	 */
	public static boolean askforanother()
	{
		System.out.println("Another time? y/n");
		return(in.nextLine().equalsIgnoreCase("y"));
	}
	
	/**
	 * takes barcode, converts it to zip code, prints it
	 * @param bar the barcode
	 */
	public static void getBarandconvert(String bar)
	{
		System.out.println(ZipBarConverter.barToZip(bar));
	}
	
	/**
	 * takes int and converts it to barcode and prints it
	 * @param zip initial zipcode
	 */
	public static void getZipandconvert(int zip)
	{
		System.out.println(ZipBarConverter.zipToBar(zip) );

	}


}
