package yahtzee.ui;

import java.util.ArrayList;

public class Game {
	
	private Scorecard s;
	private Hand h;
	private int rollsLeft;
	
	/**
	 * Creates a game
	 */
	public Game(){
		s = new Scorecard();
		h = new Hand();
		rollsLeft = 2;
	}
	
	/**
	 * Starts a new round and rolls all 5 dice
	 * @return a string representing the dice
	 */
	public String newRound(){
		rollsLeft = 2;
		h = new Hand();
		ArrayList<Integer> toRoll = new ArrayList<Integer>();
		for( int i = 0; i < 5; i++)
			toRoll.add(new Integer(i));
		h.rollDie(toRoll);
//		h.rollDie( new Integer[] {new Integer(0), new Integer(1), new Integer(2), 
//				new Integer(3), new Integer(4)} );
		return h.toString();
	}
	
	/**
	 * Rolls the selected dice
	 * @param toRoll the indices of the dice to be rolled
	 * @return null if no more rolls allowed, a string representing the dice otherwise
	 */
	public String runTurn(ArrayList<Integer> toRoll){
		if( rollsLeft < 1)
			return null;
		if( toRoll.size() == 0 )
			return h.toString();
		
//		Integer[] arr = (Integer[]) toRoll.toArray();
		h.rollDie(toRoll);		
		return h.toString();
	}
	
	/**
	 * Sets the score for the given scoretype to the correct score of the current dice
	 * @param sc
	 */
	public void chooseScore( ScoreType sc ){
		s.setScore(sc, h.getScore(sc));
	}
	
	/**
	 * Returns an array of all the scores
	 * @return an array of all the scores
	 */
	public int[] getScores(){
		return s.getScorecard();
	}
	
	/**
	 * returns a string representation of the scores
	 * @return a string representation of the scores
	 */
	public String getScoreCard(){
		return s.toString();
	}
	
	/**
	 * Returns true if all boxes are full, false otherwise
	 * @return true if all boxes are full, false otherwise
	 */
	public boolean allBoxesFull(){
		return s.isFull();
	}
	
	/**
	 * Returns an array with all the dice
	 * @return an array with all the dice
	 */
	public int[] getHand(){
		return h.getHand();
	}
	
	/**
	 * The number of rolls left in the round
	 * @return The number of rolls left in the round
	 */
	public int rollsLeft(){
		return rollsLeft;
	}
	
	/**
	 * Returns the hand as a string
	 * @return the hand as a string
	 */
	public String getHandString(){
		return h.toString();
	}
	
	/**
	 * The total score
	 * @return the total score
	 */
	public int getTotalScore(){
		return s.getTotalScore();
	}
	
	/**
	 * Returns whether a certain box on the scorecard is filled
	 * @param st
	 * @return
	 */
	public boolean boxIsFilled(ScoreType st)
	{
		return s.isFilled(st);
	}
}


