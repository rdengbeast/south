package sudoku;

public class Space {

	private int Number;	
	public Space()
	{
		Number = 0;
	}
	public Space(int num)
	{
		Number = num;
	}
	public int getNumber()
	{
		return Number;
	}

	public void PutBack()
	{
		Number = 0;
	}
	public void setNumber(int n)
	{
		Number = n;
	}

}
