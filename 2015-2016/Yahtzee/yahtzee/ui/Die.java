package yahtzee.ui;

public class Die {
	
	private int currentSide;
	
	/**
	 * Constructors for Die class
	 */
	
	public Die(){
		currentSide = 0;
	}
	
	public Die(int side){
		currentSide = side;
	}
	
	
	/**
	 * Rolls the current die
	 */
	public void roll(){
		currentSide = (int)(Math.random() * 6 + 1);
	}
	
	/**
	 * returns the faceup side of the die
	 * @return the faceup side of the die
	 */
	public int currentSide(){
		return currentSide;
	}
	 
	@Override
	public String toString(){
		return currentSide + "";
	}
	
	/**
	 * returns an ASCII depiction of the die
	 * @return the ASCII depiction of the die with each entry as a string representing a row 
	 */
	public String[] getAsciiDie(){
		if(currentSide == 1)
			return new String[] {" ________ ","|        |","|        |","|   •    |", "|        |","|________|"};
		else if(currentSide == 2)
			return new String[] {" ________ ","|        |","|  •     |","|        |", "|     •  |","|________|"};
		else if(currentSide == 3)
			return new String[] {" ________ ","|        |","| •      |","|   •    |", "|     •  |","|________|"};
		else if(currentSide == 4)
			return new String[] {" ________ ","|        |","| •    • |","|        |", "| •    • |","|________|"};
		else if(currentSide == 5)
			return new String[] {" ________ ","|        |","| •    • |","|    •   |", "| •    • |","|________|"};
		else if(currentSide == 6)
			return new String[] {" ________ ","|        |","| •    • |","| •    • |", "| •    • |","|________|"};

		return null;
	}
}
