package yahtzee.ui;

import java.util.ArrayList;

public class Hand {
	public static final int NUM_OF_DIE = 5;
	private Die[] dice;
	
	/**
	 * Constructor for Hand class
	 */
	public Hand(){
		dice = new Die[NUM_OF_DIE];
		for(int i = 0; i < NUM_OF_DIE; i++)
			dice[i] = new Die();
	}
	
	public Hand( Die[] theDice ){
		dice = theDice;		
	}
	
	/**
	 * Rolls the specified dice
	 * @param toRoll Index numbers of the dice to be rolled
	 */
	public void rollDie(ArrayList<Integer> toRoll){
//		for(int i = 0; i < toRoll.size(); i++)
//			if(toRoll.get(i) >= 0)
//				dice[toRoll.get(i)].roll();
		
		for( Integer x : toRoll)
			dice[x].roll();
	}
	
	@Override
	public String toString(){
		String returnString = "";
		for(int i = 0; i < dice[0].getAsciiDie().length; i++)
		{
			for(int j = 0; j < NUM_OF_DIE; j++)
			{
				returnString += dice[j].getAsciiDie()[i];
			}
			returnString += "\n";
		}
		return returnString;
	}
	
	/**
	 * Returns the current faceup sides of the dice
	 * @return the current faceup sides of the dice
	 */
	public int[] getHand(){
		int[] returnArr = new int[NUM_OF_DIE];
		for(int i = 0; i < NUM_OF_DIE; i++)
			returnArr[i] = dice[i].currentSide();
		return returnArr;
	}
	
	public int getScore( ScoreType s){
		int score = 0;
		switch( s ){
		case ONES:
			score = getOnes();
			break;
		case TWOS:
			score = getTwos();
			break;
		case THREES:
			score = getThrees();
			break;
		case FOURS:
			score = getFours();
			break;
		case FIVES:
			score = getFives();
			break;
		case SIXES:
			score = getSixes();
			break;
		case CHANCE:
			score = getChance();
			break;
		case TRIPLE:
			score = getTriple();
			break;
		case QUADRUPLE:
			score = getQuadruple();
			break;
		case SSTRAIGHT:
			score = getSmallStraight();
			break;
		case LSTRAIGHT:
			score = getLargeStraight();
			break;
		case FULLHOUSE:
			score = getFullHouse();
			break;
		case YAHTZEE:
			score = getYahtzee();
			break;
		}
		
		return score;
	}
	
	/**
	 * Returns the score if the hand was counted as ones
	 * @return the score if the hand was counted as ones
	 */
	public int getOnes(){
		return getNumScore(1);
	}
	
	/**
	 * Returns the score if the hand was counted as twos
	 * @return the score if the hand was counted as twos
	 */
	public int getTwos(){
		return getNumScore(2);
	}
	
	/**
	 * Returns the score if the hand was counted as threes
	 * @return the score if the hand was counted as threes
	 */
	public int getThrees(){
		return getNumScore(3);
	}
	
	/**
	 * Returns the score if the hand was counted as fours
	 * @return the score if the hand was counted as fours
	 */
	public int getFours(){
		return getNumScore(4);
	}
	
	/**
	 * Returns the score if the hand was counted as fives
	 * @return the score if the hand was counted as fives
	 */
	public int getFives(){
		return getNumScore(5);
	}
	
	/**
	 * Returns the score if the hand was counted as sixes
	 * @return the score if the hand was counted as sixes
	 */
	public int getSixes(){
		return getNumScore(6);
	}
	
	/**
	 * Returns the score if the hand was counted as triple
	 * @return the score if the hand was counted as triple
	 */
	public int getTriple(){
		int[] sorted = sortHand();
		boolean isTriple = false;
		for(int i = 0; i < NUM_OF_DIE - 2; i++)
			if(sorted[i] == sorted[i+1] && sorted[i+1] == sorted[i+2])
				isTriple = true;
		
		if(isTriple)
			return getHandTotal();
		else
			return 0;
	}
	
	/**
	 * Returns the score if the hand was counted as quadruple
	 * @return the score if the hand was counted as quadruple
	 */
	public int getQuadruple(){
		int[] sorted = sortHand();
		boolean isQuad = false;
		for(int i = 0; i < NUM_OF_DIE - 3; i++)
			if(sorted[i] == sorted[i+1] && sorted[i+1] == sorted[i+2] && sorted[i+2] == sorted[i + 3])
				isQuad = true;
		
		if(isQuad)
			return getHandTotal();
		else
			return 0;
	}
	
	/**
	 * Returns the score if the hand was counted as small straight
	 * @return the score if the hand was counted as small straight
	 */
	public int getSmallStraight(){
		if(!(handContains(3) && handContains(4)))
			return 0;
		
		if( (handContains(1) && handContains(2)) || 
				(handContains(2) && handContains(5)) ||
				(handContains(5) && handContains(6)))
			return 30;
		
		return 0;
	}
	
	/**
	 * Returns the score if the hand was counted as large straight
	 * @return the score if the hand was counted as large straight
	 */
	public int getLargeStraight(){
		int[] sorted = sortHand();
		for(int i = 0; i < NUM_OF_DIE - 1; i++)
			if(sorted[i + 1] != sorted[i] + 1)
				return 0;
		return 40;
	}
	
	/**
	 * Returns the score if the hand was counted as full house
	 * @return the score if the hand was counted as full house
	 */
	public int getFullHouse(){
		int[] sorted = sortHand();
		
		if( sorted[0] == sorted[1] && sorted[0] != sorted[NUM_OF_DIE - 1] 
				&& sorted[NUM_OF_DIE - 2] == sorted[NUM_OF_DIE - 1] 
				&& ( sorted[2] == sorted[1] || sorted[2] == sorted[3] ) )
			return 25;
		else
			return 0;
		
	}
	
	/**
	 * Returns the score if the hand was counted as yahtzee
	 * @return the score if the hand was counted as yahtzee
	 */
	public int getYahtzee(){
		int[] dieNums = getHand();
		for(int i = 1; i < NUM_OF_DIE; i++)
			if(dieNums[i] != dieNums[0])
				return 0;
		return 50;
	}
	
	/**
	 * Returns the score if the hand was counted as chance
	 * @return the score if the hand was counted as chance
	 */
	public int getChance(){
		return getHandTotal();
	}
	
	private int getNumScore(int x){
		int total = 0;
		for(int i = 0; i < NUM_OF_DIE; i++)
			if(getHand()[i] == x)
				total += x;
		return total;
	}
	
	private int getHandTotal(){
		int total = 0;
		for(int i = 0; i < NUM_OF_DIE; i++)
			total += getHand()[i];
		return total;
	}
	
	private int[] sortHand(){
		int[] diceNums = getHand();
		for( int i = 1; i < diceNums.length; i++)
        {
        	int tempNum = diceNums[i];
        	int j = i-1;
        	while(j >= 0 && diceNums[j] > tempNum){
        		diceNums[j+1] = diceNums[j];
        		j--;
        	}
        	diceNums[j+1] = tempNum;
        }
		return diceNums;
	}
	
	private boolean handContains(int x){
		int[] diceNums = getHand();
		for(int i = 0; i < diceNums.length; i++)
			if(diceNums[i] == x)
				return true;
		return false;
	}
}


