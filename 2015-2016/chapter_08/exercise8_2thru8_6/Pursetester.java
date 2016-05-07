package exercise8_2thru8_6;

public class Pursetester {

	public static void main(String [] args)
	{
		Purse purse = new Purse();
		purse.addCoin("quarter");
		purse.addCoin("dime");
		purse.addCoin("nickel");
		purse.addCoin("penny");
		System.out.println(purse);

		Purse purse2 = new Purse();
		purse2.addCoin("quarter");
		purse2.addCoin("dime");
		purse2.addCoin("nickel");
		purse2.addCoin("penny");
//		purse2.addCoin("nickel");
		System.out.println(purse2);
//		purse.transfer(purse2);
		System.out.println(purse.sameCoins(purse2));
	}
}
