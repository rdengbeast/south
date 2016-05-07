package yahtzee.ui;

import java.util.Arrays;
import java.util.HashMap;
public class Scorecard {
	

	
	private int[] scores;
	
	/**
	 * Constructor for the Scorecard class
	 */
	public Scorecard(){
		scores = new int[13];
		for( int i = 0; i < scores.length; i++){
			scores[i] = -1;
		}
	}
	
	/**
	 * Returns the numbers on the scorecard
	 * @return An array with the numbers on the scorecard
	 */
	public int[] getScorecard(){
		int[] x = new int[13];
		x = Arrays.copyOf(scores, scores.length);
		return x;		
	}
	
	
	/**
	 * Returns the player's total score
	 * @return the player's total score
	 */
	public int getTotalScore(){
		int sum = 0;
		for( int i = 0; i < 6; i++)
			sum += (scores[i] > 0 ) ? scores[i] : 0;
		if(sum >= 63)
			sum += 35;
		for(int i = 6; i < 13; i++)
			sum += (scores[i] > 0 ) ? scores[i] : 0;

		return sum;
	}
	
	@Override
	public String toString(){
		String returnString = "Scorecard: ";
		
		returnString += "\nA: Ones: " + ((scores[ScoreType.ONES.getIndex()] > -1) ? 
				scores[ScoreType.ONES.getIndex()] : "__");
		returnString += "\nB: Twos: " + ((scores[ScoreType.TWOS.getIndex()] > -1) ? 
				scores[ScoreType.TWOS.getIndex()] : "__");
		returnString += "\nC: Threes: " + ((scores[ScoreType.THREES.getIndex()] > -1) ? 
				scores[ScoreType.THREES.getIndex()] : "__");
		returnString += "\nD: Fours: " + ((scores[ScoreType.FOURS.getIndex()] > -1) ? 
				scores[ScoreType.FOURS.getIndex()] : "__");
		returnString += "\nE: Fives: " + ((scores[ScoreType.FIVES.getIndex()] > -1) ? 
				scores[ScoreType.FIVES.getIndex()] : "__");
		returnString += "\nF: Sixes: " + ((scores[ScoreType.SIXES.getIndex()] > -1) ? 
				scores[ScoreType.SIXES.getIndex()] : "__");
		returnString += "\nG: Chance: " + ((scores[ScoreType.CHANCE.getIndex()] > -1) ? 
				scores[ScoreType.CHANCE.getIndex()] : "__");
		returnString += "\nH: Triple: " + ((scores[ScoreType.TRIPLE.getIndex()] > -1) ? 
				scores[ScoreType.TRIPLE.getIndex()] : "__");
		returnString += "\nI: Quadruple: " + ((scores[ScoreType.QUADRUPLE.getIndex()] > -1) ? 
				scores[ScoreType.QUADRUPLE.getIndex()] : "__");
		returnString += "\nJ: Small Straight: " + ((scores[ScoreType.SSTRAIGHT.getIndex()] > -1) ? 
				scores[ScoreType.SSTRAIGHT.getIndex()] : "__");
		returnString += "\nK: Large Straight: " + ((scores[ScoreType.LSTRAIGHT.getIndex()] > -1) ? 
				scores[ScoreType.LSTRAIGHT.getIndex()] : "__");
		returnString += "\nL: Full House: " + ((scores[ScoreType.FULLHOUSE.getIndex()] > -1) ? 
				scores[ScoreType.FULLHOUSE.getIndex()] : "__");
		returnString += "\nM: Yahtzee: " + ((scores[ScoreType.YAHTZEE.getIndex()] > -1) ? 
				scores[ScoreType.YAHTZEE.getIndex()] : "__");

				
		return returnString;
	}
	
	/**
	 * Sets the score of a certain part of a scorecard
	 * @param index The index of the score to be set
	 */
	public void setScore(ScoreType s, int x){
		scores[s.getIndex()] = x;
	}
	
	public boolean isFull(){
		for( int x : scores)
			if (x == -1)
				return false;
		return true;
	}
	
	public boolean isFilled(ScoreType s){
		return scores[s.getIndex()] != -1;
	}
}




