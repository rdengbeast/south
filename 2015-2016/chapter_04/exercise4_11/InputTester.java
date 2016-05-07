package exercise4_11;

import java.util.Scanner;

/**
   This class tests console input.
*/
public class InputTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);

      CashRegister register = new CashRegister();

      System.out.print("Enter price: ");
      double price = in.nextDouble();
      register.recordPurchase(price);

      System.out.print("Enter dollars: ");
      int dollars = in.nextInt();
      System.out.print("Enter quarters: ");
      int quarters = in.nextInt();
      System.out.print("Enter dimes: ");
      int dimes = in.nextInt();
      System.out.print("Enter nickels: ");
      int nickels = in.nextInt();
      System.out.print("Enter pennies: ");
      int pennies = in.nextInt();
      register.enterPayment(dollars, quarters, dimes, nickels, pennies);

      System.out.print("Your change is ");
      System.out.println(register.giveDollars() + " dollars, ");
      System.out.println(register.giveQuarters() + " quarters, ");
      System.out.println(register.giveDimes() + " dimes, " );
      System.out.println(register.giveNickels() + " nickels, ");
      System.out.println(register.givePennies() + " pennies. ");
   }
}
