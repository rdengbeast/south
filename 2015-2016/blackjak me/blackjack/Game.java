package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game 
{

	private double money, bet, insurance;
	private List<Cardme> shoe = new ArrayList<Cardme>();
	private List<Cardme> playerhand = new ArrayList<Cardme>();
	private List<Cardme> dealerhand = new ArrayList<Cardme>();
	private final char[] names = {'2', '3', '4', '5', '6', '7', '8', '9', 't', 'J', 'Q', 'K', 'A'};
	private final char[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
	private final char[] suits = {'d', 'c', 's', 'h'};
	
	public Game()
	{
		money = 1000;
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < names.length; j++)
				for(char suit : suits)
					shoe.add(new Cardme(names[j], values[j], suit));
		
		Collections.shuffle(shoe);
	}

	public Cardme[] deal()
	{
		playerhand = new ArrayList<Cardme>();
		dealerhand = new ArrayList<Cardme>();
		bet = 0;
		insurance = 0;
		
		Cardme[] cards = new Cardme[3];
		Cardme c1, c2, c3, c4;
		
		c1 = shoe.remove(shoe.size() - 1);
		cards[1] = c1;
		c2 = shoe.remove(shoe.size() - 1);
		cards[2] = c2;
		
		c3 = shoe.remove(shoe.size() - 1);
		cards[0] = c3;
		
		c4 = shoe.remove(shoe.size() - 1);


		playerhand.add(c1);
		playerhand.add(c2);
		dealerhand.add(c3);
		dealerhand.add(c4);
		
		return cards;
	}
	
	public void insurance(double money)
	{
		insurance = money;
	}
	public void insurancewin()
	{
		money += 3 * insurance;
	}
	public void bet(double bet)
	{
		this.bet = bet;
		money -= bet;
	}
	
	public Cardme dawble()
	{
		money -= bet;
		bet = bet * 2;
		return hit();
	}
	public Cardme hit()
	{
		Cardme yes = shoe.remove(shoe.size()-1);
		playerhand.add( yes);
		return yes;
	}
	public void surrender()
	{
		money += bet / 2;
	}
	private Cardme dhit()
	{
		Cardme yes = shoe.remove(shoe.size()-1);
		dealerhand.add(yes);
		return yes;
	}
	
	public void dealerturn()
	{
		while(sum(dealerhand) < 17)
			dhit();
	}
	public int dsum()
	{
		return sum(dealerhand);
	}
	public int psum()
	{
		return sum(playerhand);
	}
	private int sum(List<Cardme> cards)
	{
		int sum = 0;
		boolean x = false;
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i).getName() == 'A')
				x = true;
			sum += cards.get(i).getVal();
		}
		if(x && sum > 21)
			sum -= 10;
		
		return sum;
	}
	public double getBet()
	{
		return  bet;
	}
	public double getMoney()
	{
		return money;
	}
	public void bj()
	{
		money += bet * 2.5;
	}
	public void win()
	{
		money += bet * 2;
	}
	public void tie()
	{
		money += bet;
	}
}
