package exercise4_11;

/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
   /**
      Enters the payment received from the customer.
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void enterPayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      payment = dollars + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
      change = payment - purchase;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
   
   public int giveDollars()
   {
	   int dollarschange = (int)( change / 1 );
	   change -= dollarschange;
	   return dollarschange;
   }
   public int giveQuarters()
   {
	   int quarterschange = (int)(change / QUARTER_VALUE);
	   change -= quarterschange * QUARTER_VALUE;
	   return quarterschange;
   }
   public int giveDimes()
   {
	   int dimeschange = (int)( change / DIME_VALUE );
	   change -= dimeschange * DIME_VALUE;
	   return dimeschange;
   }
   public int giveNickels()
   {
	   int nickelschange = (int)( change / NICKEL_VALUE);
	   change -= nickelschange * NICKEL_VALUE;
	   return nickelschange;
   }
   public int givePennies()
   {
	   return (int)( change / PENNY_VALUE );
   }

   public static final double QUARTER_VALUE = 0.25;
   public static final double DIME_VALUE = 0.1;
   public static final double NICKEL_VALUE = 0.05;
   public static final double PENNY_VALUE = 0.01;

   private double purchase;
   private double payment;
   private double change;
}
