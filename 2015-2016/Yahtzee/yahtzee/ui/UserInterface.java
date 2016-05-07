package yahtzee.ui;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	
	public static final int ALLOWED_ROLLS = 2;
		
	public static void play()
	{
		Scanner in  = new Scanner(System.in);
		int numRolls = 0;

		Game g = new Game();
		while(!g.allBoxesFull())
		{
			numRolls = 0;
			
			System.out.println(g.getScoreCard());
			
			System.out.println("Rolling stones:");
			
			g.newRound();
			numRolls++;
			
			System.out.println("Die numbers:");
			System.out.println("     1         2         3         4         5");
			System.out.println(g.getHandString());

						
			while(numRolls <= ALLOWED_ROLLS){
				
				System.out.println("Enter which dice to keep using the die numbers displayed above the dice,"
						+ " or enter \"stop\" to score current dice");
				String input = in.nextLine();
				
				ArrayList<Integer> toRoll = new ArrayList<Integer>();

				for(int i = 0; i < 5; i++)
					toRoll.add(i);

				if( input.toLowerCase().equals("stop") )
					break;
				

				for(int i = 0; i < 5; i++){
					
					Integer newIndex = i + 1;
					if(input.indexOf(newIndex.toString()) > -1){
						toRoll.remove((Integer)(i));
					}
				}
				
				if( toRoll.size() == 0 )
					break;
				
				boolean isValid = true;
				for( int i = 6; i <= 9; i++)
					if( input.indexOf("" + i) > -1)
						isValid = false;
				
				if(input.indexOf("0") > -1)
					isValid = false;
				
				if(!isValid){
					System.out.println("Only dice numbers from 1 to 5 are valid.");
					continue;
				}

				g.runTurn(toRoll);

				System.out.println("Dice numbers:");
				System.out.println("     1         2         3         4         5");
				System.out.println(g.getHandString());
				numRolls++;

			}
						
			System.out.println("choose which box to fill by typing in the name of the box(e.g. Large straight): ");
			String choice = in.nextLine().toLowerCase().trim();

			boolean isValid = false;
			while( !isValid ){
				isValid = true;
				
				char firstChar = choice.charAt(0);
				if(choice.length() == 1 && Character.isAlphabetic(firstChar)) {
					if(firstChar-'a' <= 12 && !g.boxIsFilled( ScoreType.values()[(firstChar-'a')] ))
						g.chooseScore(ScoreType.values()[(firstChar-'a')]);
					else 
					{
						isValid = false;
						System.out.println("Not a valid entry.");
						System.out.println("choose which box to fill by typing in the name of the box(e.g. Large straight): ");
						choice = in.nextLine().toLowerCase().trim();
					}
				}
				else if ((choice.equals("ones") || choice.equals("1s") 
						|| choice.equals("1") || choice.equals("one")) && !g.boxIsFilled(ScoreType.ONES))
					g.chooseScore(ScoreType.ONES);
				else if( (choice.equals("twos") || choice.equals("2s") 
						|| choice.equals("2") || choice.equals("two")) && !g.boxIsFilled(ScoreType.TWOS))
					g.chooseScore(ScoreType.TWOS);
				else if( (choice.equals("threes") || choice.equals("3s") 
						|| choice.equals("3") || choice.equals("three")) && !g.boxIsFilled(ScoreType.THREES))
					g.chooseScore(ScoreType.THREES);
				else if( (choice.equals("fours") || choice.equals("4s") 
						|| choice.equals("4") || choice.equals("four")) && !g.boxIsFilled(ScoreType.FOURS))
					g.chooseScore(ScoreType.FOURS);
				else if( (choice.equals("fives") || choice.equals("5s") 
						|| choice.equals("5") || choice.equals("five")) && !g.boxIsFilled(ScoreType.FIVES))
					g.chooseScore(ScoreType.FIVES);
				else if( (choice.equals("sixes") || choice.equals("6s") 
						|| choice.equals("6") || choice.equals("six")) && !g.boxIsFilled(ScoreType.SIXES))
					g.chooseScore(ScoreType.SIXES);
				else if( ( choice.equals("triple") || choice.equals("triples") 
						|| choice.equals("trip")) && !g.boxIsFilled(ScoreType.TRIPLE))
					g.chooseScore(ScoreType.TRIPLE);
				else if( ( choice.equals("quadruple") || choice.equals("quad") 
						|| choice.equals("quaduples")) && !g.boxIsFilled(ScoreType.QUADRUPLE))
					g.chooseScore(ScoreType.QUADRUPLE);
				else if( ( choice.equals("sstraight") || choice.equals("small straight") 
						|| choice.equals("smallstraight") || choice.equals("s straight")) && !g.boxIsFilled(ScoreType.SSTRAIGHT))
					g.chooseScore(ScoreType.SSTRAIGHT);
				else if ( ( choice.equals("lstraight")|| choice.equals("large straight") 
						|| choice.equals("largestraight") || choice.equals("l straight")) && !g.boxIsFilled(ScoreType.LSTRAIGHT))
					g.chooseScore(ScoreType.LSTRAIGHT);
				else if ( ( choice.equals("fullhouse") || choice.equals("full house")) && !g.boxIsFilled(ScoreType.FULLHOUSE))
					g.chooseScore(ScoreType.FULLHOUSE);
				else if( choice.equals("yahtzee") && !g.boxIsFilled(ScoreType.YAHTZEE))
					g.chooseScore(ScoreType.YAHTZEE);
				else if( choice.equals("chance") && !g.boxIsFilled(ScoreType.CHANCE))
					g.chooseScore(ScoreType.CHANCE);
				else{
					isValid = false;
					System.out.println("Not a valid entry.");
					System.out.println("choose which box to fill by typing in the name of the box(e.g. Large straight): ");
					choice = in.nextLine().toLowerCase().trim();
				}
			}
			 
		}
		
		System.out.println(g.getScoreCard());
		
		System.out.println("Your total score is: " + g.getTotalScore());
		
		System.out.println();
	}
	
	public static void main( String [] args){
		play();
	}
	}