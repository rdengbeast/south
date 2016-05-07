package blackjack;
import java.util.Scanner;
public class Interface {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Game g = new Game();
		boolean cont = true;
		boolean surrender = false;
		while(g.getMoney() > 0 && cont)
		{
			surrender = false;
			System.out.println("$: " + g.getMoney());
			Cardme[] initial = g.deal();
			
			System.out.println("bet?");
			g.bet(in.nextDouble());
			
			System.out.println("dealer cards: [ ]" + "[" + initial[0] + "]");
			System.out.println("your cards: " + initial[1] + ",  " + initial[2]);
			
			if(initial[0].getName() == 'A')
			{
				System.out.println("insurance? y/n");
				if(in.next().equals("y"))
				{
					System.out.println("how much?");
					double x = in.nextDouble();
					while(x > g.getBet() / 2)
					{
						System.out.println("max insurance is half original bet: enter again");
						x = in.nextDouble();
					}
					g.insurance(x);
				}
			}

			int p = g.psum();
			int d = g.dsum();
			
			if(d == 21)         //if dealer blackjack
			{
				g.insurancewin();
				if(p == 21)
				{
					g.tie();
					System.out.println("both have blackjack");
				}
			}
			else if(p == 21)
			{
				g.bj();
				System.out.println("blackjack");
			}
			else	
			{
				//PLAYERS TURN
				System.out.println("hit or stand or double or surreder??(h/s/d/su)");
				switch(in.next())
				{
					case("h"):
						do
						{
							System.out.println("your card:  " + g.hit() );
							p = g.psum();
						}while (p <= 21 && in.next().equals("h"));
						break;
//					case("s"):
//						break;
					case("d"):
						System.out.println("your card: " + g.dawble());
						break;
					case("su"):
						g.surrender();
						surrender = true;
						break;
				}
				
				if(p > 21 && !surrender)
					System.out.println("bust :" + p);
				else if( !surrender )
				{
					g.dealerturn();
	
					d = g.dsum();
					System.out.println("sums: u: " + p + " , d: " + d);
				
					if(p == 21)
					{
						if(g.dsum() == 21)
						{
							System.out.println("tie");
							g.tie();
						}
						else
						{
							g.bj();
							System.out.println("blackjack");
						}
					}
					else if(d > 21 || p > d)
					{
						System.out.println("win");
						g.win();
					}
					else if( d == p)
					{
						System.out.println("tie");
						g.tie();
					}
				}
			}	
			System.out.println("$" + g.getMoney() + " again?(y/n)");
			cont = in.next().equals("y");
		}
		System.out.println("ya lose bud");
	}

}
