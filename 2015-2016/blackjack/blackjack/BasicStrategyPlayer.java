package blackjack;

import java.util.List;

public class BasicStrategyPlayer implements BlackjackPlayer{

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
	public void faceUpCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		
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

	@Override
	public String id() 
	{
		return "BasicallyRichard";
	}

	@Override
	public double bet(double minBet, double maxBet) 
	{
//		return (minBet + maxBet) / 2;
//		return maxBet;
		return minBet;
	}

	@Override
	public PlayerAction act(List<Card> ownHand, Card dealerUpCard,
			List<PlayerAction> allowedActions) 
	{
		PlayerAction x = null;
		PlayerAction x2 = null;
		String action = "";
		
		String[][] hardactions = {
			//2     3     4     5     6     7    8     9      10    A
			{"H",  "DH", "DH", "DH", "DH", "H",  "H",  "H",  "H",  "H",}, //9 IF UNDER 9, HIT
			{"DH", "DH", "DH", "DH", "DH", "DH", "DH", "DH", "H",  "H",}, //10
			{"DH", "DH", "DH", "DH", "DH", "DH", "DH", "DH", "DH", "H",}, //11
			{"H",  "H",  "S",  "S",  "S",  "H",  "H",  "H",  "H",  "H",}, //12
			{"S",  "S",  "S",  "S",  "S",  "H",  "H",  "H",  "H",  "H",}, //13
			{"S",  "S",  "S",  "S",  "S",  "H",  "H",  "H",  "H",  "H",}, //14
			{"S",  "S",  "S",  "S",  "S",  "H",  "H",  "H",  "RH", "H",}, //15
			{"S",  "S",  "S",  "S",  "S",  "H",  "H",  "RH", "RH", "RH",}, //16   IF OVER 16 ALWAYS STAND
		};
		
		String [][] softactions = {
			{"H", "H",  "H",  "DH", "DH", "H", "H", "H", "H", "H",}, //13
			{"H", "H",  "H",  "DH", "DH", "H", "H", "H", "H", "H",}, //14
			{"H", "H",  "DH", "DH", "DH", "H", "H", "H", "H", "H",},
			{"H", "H",  "DH", "DH", "DH", "H", "H", "H", "H", "H",},
			{"H", "DH", "DH", "DH", "DH", "H", "H", "H", "H", "H",},
			{"S", "DS", "DS", "DS", "DS", "S", "S", "H", "H", "H",},//18
			
		};
		
		String [][] splitactions = {

			{"P",  "P",  "P",  "P",  "P",  "P",  "P",  "P",  "P", "P"}, //A, A
			{"PH", "PH",  "P",  "P",  "P",  "P",  "H",  "H",  "H", "H"}, //2
			{"PH", "PH",  "P",  "P",  "P",  "P",  "H",  "H",  "H", "H"}, //3
			{"H",  "H",  "H",  "PH",  "PH",  "H",  "H",  "H",  "H", "H"},//4
			{"DH", "DH", "DH", "DH", "DH", "DH", "DH", "DH", "H", "H"}, //5, 5
			{"PH", "P",  "P",  "P",  "P",  "H",  "H",  "H",  "H", "H"}, //6 SIX SIX SIX SIX
			{"P",  "P",  "P",  "P",  "P",  "P",  "H",  "H",  "H", "H"}, //7
			{"P",  "P",  "P",  "P",  "P",  "P",  "P",  "P",  "P", "P"}, //8
			{"P",  "P",  "P",  "P",  "P",  "S",  "P",  "P",  "S", "S"}, //9
			{"S",  "S",  "S",  "S",  "S",  "S",  "S",  "S",  "S", "S"}, //10,10

			
		};
		
		boolean split = ownHand.size() == 2 && ownHand.get(0).value().numericValue() == (ownHand.get(1).value().numericValue());
		
		if(split)
		{
			if(ownHand.get(0).value().toString().equals("A"))
			{
				if(allowedActions.contains(PlayerAction.SPLIT))
					return PlayerAction.SPLIT;
				return PlayerAction.STAND;
			}
			
			if( dealerUpCard.value().toString().equals("A") )
				action = splitactions[ownHand.get(0).value().numericValue() - 1][9];
			else
				action = splitactions[ownHand.get(0).value().numericValue() - 1][dealerUpCard.value().numericValue()-2];				
		}	
		
		if((!HandUtilities.soft(ownHand) && !split) || ( action.equals("P") && !allowedActions.contains(PlayerAction.SPLIT)))     //if not soft hand
		{
			int ownHandval = HandUtilities.value(ownHand);
			
			if( ownHandval <= 8)
				return PlayerAction.HIT;
			if(ownHandval >= 17)
				return PlayerAction.STAND;
			
			if( dealerUpCard.value().toString().equals("A") )
			{
				action = hardactions[ownHandval-9][9];
			}
			else
			{
				action = hardactions[ownHandval-9][dealerUpCard.value().numericValue()-2];
			}	
			
		}
		else if(HandUtilities.soft(ownHand) && !split)
		{
			int ownHandval = HandUtilities.value(ownHand);
			
			if(ownHandval >= 19)
				return PlayerAction.STAND;
			
			if( dealerUpCard.value().toString().equals("A") )
			{
				action = softactions[ownHandval - 13][9];
			}
			else
			{
				action = softactions[ownHandval - 13][dealerUpCard.value().numericValue()-2];
			}
			
		}
		
		
		switch(action)
		{
			case "H":
				x = PlayerAction.HIT;
				break;
				
			case "DH":
				x = PlayerAction.DOUBLE;
				x2 = PlayerAction.HIT;
				break;
				
			case "DS":
				x = PlayerAction.DOUBLE;
				x2 = PlayerAction.STAND;
				break;
				
			case "S":
				x = PlayerAction.STAND;
				break;
				
			case "P":
				x = PlayerAction.SPLIT;
				break;
				
			case "PH":
				x = PlayerAction.SPLIT;
				x2 = PlayerAction.HIT;
				break;
				
			case "RH":
				x = PlayerAction.SURRENDER;
				x2 = PlayerAction.HIT;
				break;

		}
		
		if(allowedActions.contains(x))
			return x;
		return x2;
		
	}

	@Override
	public boolean insureHand(List<Card> ownHand, Card dealerUpCard) {
		// TODO Auto-generated method stub
		return false;
	}

}
