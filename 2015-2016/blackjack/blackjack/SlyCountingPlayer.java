package blackjack;

import java.util.List;

public class SlyCountingPlayer extends BasicStrategyPlayer
{
	private double count = 0;
	private double cardsleft = 312;
	private double tensleft = 96;
	@Override
	public void playerIDs(List<String> playerIDs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialBet(int playerIndex, double bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialBets(List<Double> bets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void faceUpCard(Card card) 
	{
	
		cardsleft--;
		switch(card.value().numericValue())
		{
//			wong halves		
//			case 1: 
//				count -= 1;
//				break;
//			case 2:
//				count += 0.5;
//				break;
//			case 3: 
//				count += 1;
//				break;
//			case 4: 
//				count += 1;
//				break;
//			case 5: 
//				count += 1.5;
//				break;
//			case 6: 
//				count += 1;
//				break;
//			case 7: 
//				count += 0.5;
//				break;
//			case 9: 
//				count -= 0.5;
//				break;
//			case 10:
//				count -= 1;
//				tensleft--;
//				break;
		
		//HILO
		case 1: 
			count -= 1;
			break;
		case 2:
			count++;
			break;
		case 3: 
			count++;
			break;
		case 4: 
			count++;
			break;
		case 5: 
			count++;
			break;
		case 6: 
			count++;
			break;
		case 7: 
			break;
		case 9: 
			break;
		case 10:
			count--;
			tensleft--;
			break;
		}
	}

	@Override
	public void shuffle() 
	{	// TODO Auto-generated method stub
		count = 0;
		tensleft = 96;
		cardsleft = 312;
	}

	@Override
	public void insuranceDecision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, boolean insuredHand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insuranceResult(int playerIndex, double bet,
			List<Card> playersHand, Card dealersUpCard, boolean insuranceBetWon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decision(int playerIndex, List<Card> playersHand,
			Card dealersUpCard, List<PlayerAction> allowedActions,
			PlayerAction action) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void result(int playerIndex, double bet, List<Card> playersHand,
			List<Card> dealersHand, Result result) {
		// TODO Auto-generated method stub
		
	}
	public String id() 
	{
		return "RichardWhoCanCount";
	}

	public double bet(double minBet, double maxBet) 
	{
		double truecount = count /(cardsleft / 52.0);
		
		double bet = minBet; 
		
		double diff = maxBet - minBet;
		

		if(truecount >= 17)
			bet = maxBet;
		else if(truecount >= 5)
			bet = minBet + count * 90;
		else bet = minBet;
		
//		if(truecount >= 7)
//			bet = maxBet;
//		else if(truecount >= 4)
//			bet = (maxBet + minBet) / 2;
//		else bet = minBet;
		
//		if(count >= 40)
//			bet = minBet + count * 700;
//		else if(count >= 9)
//			bet = minBet + count * 70;
//		else bet = minBet;
		
		if(bet > maxBet)
			bet = maxBet;
		
		if(bet < minBet)
			bet = minBet;
		
		return bet;
		
	}
	
	public PlayerAction act(List<Card> ownHand, Card dealerUpCard,
			List<PlayerAction> allowedActions) 
	{
		double truecount = count /(cardsleft / 52);
		
		if(HandUtilities.soft(ownHand))
		{
			if(HandUtilities.value(ownHand) == 16 && dealerUpCard.value().numericValue() == 10 && truecount >= 0)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 15 && dealerUpCard.value().numericValue() == 10 && truecount >= 4)
				return PlayerAction.STAND;
			else if(ownHand.get(0).value().numericValue() == 10 && ownHand.get(1).value().numericValue() == 10 && dealerUpCard.value().numericValue() == 5 && truecount >= 5)
				return PlayerAction.SPLIT;
			else if(ownHand.get(0).value().numericValue() == 10 && ownHand.get(1).value().numericValue() == 10 && dealerUpCard.value().numericValue() == 6 && truecount >= 4)
				return PlayerAction.SPLIT;
			else if(HandUtilities.value(ownHand) == 10 && dealerUpCard.value().numericValue() == 10 && truecount >= 4)
				return PlayerAction.DOUBLE;
			else if(HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 3 && truecount >= 2)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 2 && truecount >= 3)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 11 && dealerUpCard.value().numericValue() == 1 && truecount >= 1)
				return PlayerAction.DOUBLE;
			else if(HandUtilities.value(ownHand) == 9 && dealerUpCard.value().numericValue() == 2 && truecount >= 1)
				return PlayerAction.DOUBLE;
			else if(HandUtilities.value(ownHand) == 10 && dealerUpCard.value().numericValue() == 1 && truecount >= 4)
				return PlayerAction.DOUBLE;
			else if(HandUtilities.value(ownHand) == 9 && dealerUpCard.value().numericValue() == 7 && truecount >= 3)
				return PlayerAction.DOUBLE;
			else if(HandUtilities.value(ownHand) == 16 && dealerUpCard.value().numericValue() == 9 && truecount >= 5)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 13 && dealerUpCard.value().numericValue() == 2 && truecount >= -1)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 4 && truecount >= 0)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 5 && truecount >= -2)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 12 && dealerUpCard.value().numericValue() == 6 && truecount >= -1)
				return PlayerAction.STAND;
			else if(HandUtilities.value(ownHand) == 13 && dealerUpCard.value().numericValue() == 3 && truecount >= -2)
				return PlayerAction.STAND;
			
			else if(HandUtilities.value(ownHand) == 14 && dealerUpCard.value().numericValue() == 10 && truecount >= 3 && allowedActions.contains(PlayerAction.SURRENDER))
				return PlayerAction.SURRENDER;
			else if(HandUtilities.value(ownHand) == 15 && dealerUpCard.value().numericValue() == 10 && truecount >= 0 && allowedActions.contains(PlayerAction.SURRENDER))
				return PlayerAction.SURRENDER;
			else if(HandUtilities.value(ownHand) == 15 && dealerUpCard.value().numericValue() == 9 && truecount >= 2 && allowedActions.contains(PlayerAction.SURRENDER))
				return PlayerAction.SURRENDER;
			else if(HandUtilities.value(ownHand) == 15 && dealerUpCard.value().numericValue() == 1 && truecount >= 1 && allowedActions.contains(PlayerAction.SURRENDER))
				return PlayerAction.SURRENDER;
			else
				return super.act(ownHand, dealerUpCard, allowedActions);
		}
		return super.act(ownHand, dealerUpCard, allowedActions);
	}
	
	public boolean insureHand(List<Card> ownHand, Card dealerUpCard) 
	{
		if (dealerUpCard.value().numericValue() == 1 && count / (cardsleft / 52) >= 3) 
			return true;
		return false;
	}
}
