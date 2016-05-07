package zipCode;

/**
 * can convert from zipcode to barcode and vice versa
 * really cool, deserves A++++++++++++
 * @author 165156
 *
 */
public class ZipBarConverter {

	private final static char[][] zipCodeTable = {
			  							  {':', '|', ':', ':', ':'}, //0
			  							  {':', ':', ':', '|', '|'}, //1
										  {':', ':', '|', ':', '|'}, //2
										  {':', ':', '|', '|', ':'}, //3
										  {':', '|', ':', ':', '|'}, //4
										  {':', '|', ':', '|', ':'}, //5
										  {':', '|', '|', ':', ':'}, //6
										  {'|', ':', ':', ':', '|'}, //7
										  {'|', ':', ':', '|', ':'}, //8
										  {'|', ':', '|', ':', ':'}, //9
										  };
	/**
	 * takes zipcode, returns barcode
	 * @param zip
	 * @return
	 */
	public static String zipToBar(int zip)
	{ 
		String barcode ="|";
		
		int sumofdigits = 0;
		
		for (int power = 4; power >= 0; power--)
		{
			int digit = zip / (int)Math.pow(10, power);
			zip %= Math.pow(10, power);
			
			barcode += convertDigitToBarcode(digit);
			
			sumofdigits += digit;
		}
		
		if( sumofdigits != 0)
			barcode += convertDigitToBarcode(10 - sumofdigits % 10);
		else
			barcode += convertDigitToBarcode(0);

		
		barcode += "|";
		return barcode;
	}
	
	/**
	 * takes a digit and returns barcode representation of that digit
	 * @param digit
	 * @return barcode version of digit
	 */
	private static String convertDigitToBarcode(int digit)
	{
		String digitbarcode = "";
		for (int i = 0; i < 5; i++)
		{
			digitbarcode += zipCodeTable[digit][i];
		}
		return digitbarcode;
	}
	
	/**
	 * takes barcode as parameter, returns zipcode that it represents
	 * @param bar
	 * @return
	 */
	public static String barToZip(String bar)
	{
		String barwithoutframe = "";

		barwithoutframe = bar.substring(1, bar.length() - 6);

		String stringzip = "";
		
		while(barwithoutframe.length() > 0)
		{
			stringzip += "" + findBarDigit(barwithoutframe.substring(0, 5));
			barwithoutframe = barwithoutframe.substring(5);
		}
		
		return stringzip;
		
	}
	
	/**
	 * takes a five character section of barcode, returns int that it represents
	 * @param bar five character chunk of barcode
	 * @return int that above section represents
	 */
	private static int findBarDigit(String bar)
	{
		int digit = 0;
		String barcodechecker = "";

		while(!bar.equals(barcodechecker) )// && digit < 10)
		{

			barcodechecker = "";
			for (char c : zipCodeTable[digit])
			{
				barcodechecker += Character.toString(c);
			}
			digit++;
		}
		return digit - 1;
	}
}
 