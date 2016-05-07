package sudoku;

public class Sudoku {

	private Space[][] grid = new Space[9][9];
	
	public Sudoku()
	{
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[i].length; j++)
				grid[i][j] = new Space();
	}
	
	private boolean VerticalComplete(int col)
	{
		boolean allthere = true;
		
		for(int checker = 1; checker <= 9; checker++)
				allthere = allthere && VertHelp(col, checker);
		
		return allthere;
	}
	
	private boolean VertHelp(int col, int target)
	{
		for(int i = 0; i < grid.length; i++)
			if(grid[i][col].getNumber() == target)
				return true;
		
		return false;
	}
	

	private boolean HorizontalComplete(int row)
	{
		boolean allthere = true;
		for(int checker = 1; checker <= 9; checker++)
			allthere = allthere && HorizHelp(row, checker);
	
	return allthere;
	}
	
	private boolean HorizHelp(int row, int target)
	{
		for(int i = 0; i < grid.length; i++)
			if(grid[row][i].getNumber() == target)
				return true;
		
		return false;
	}

	public void Display()
	{
		for(int i = 0; i < grid.length; i++)
		{
			System.out.println();
			if(i % 3 == 0 && i != 0)
				System.out.println("_____________________");
			for(int j = 0; j < grid[i].length; j++)
			{
				if(j % 3 == 0 && j != 0)
					System.out.print("|");
				System.out.print(grid[i][j].getNumber() + " ");
			}
		}
		System.out.println();
		System.out.println("==============================");
	}
	
	/**
	 *  1 2 3
	 *  4 5 6
	 *  7 8 9
	 * @param squareindex
	 * @return
	 */
	private boolean SquareComplete(int squareindex)
	{
		boolean allthere = true;
		for(int checker = 1; checker <= 9; checker++)
			allthere = allthere && SquareHelper(squareindex, checker);
		return allthere;
	}
	private boolean SquareHelper(int squareindex, int target)
	{
		int rstart, rend, cstart, cend;
		rend = (squareindex - 1) / 3 * 3 + 2;
		rstart = rend - 2;
		cend = squareindex % 3 * 3 - 1;
		cstart = cend - 2;
		if(squareindex % 3 == 0)
		{
			cstart = 6;
			cend = 8;
		}
		
		for(int i = rstart; i <= rend; i++)
			for(int j = cstart; j <= cend; j++)
				if(grid[i][j].getNumber() == target)
					return true;
		
		return false;
		
	}
	
	public boolean MakeSudoku(int row, int col)
	{
		if(row > 8)
		{
			if(CompleteSudoku())
			{
				Display();
				System.out.println();
				return false;
			}
		}
		

		
		int[] available = getAvailable(row, col);


		if(available.length == 0)
			return false;
		
		//put next possible number at spot, if doesn't work, go to next, until it works.
		
		for(int x : available)
		{
			PutNumber(x, row, col);
			
			if(col == 8)
			{
				if(MakeSudoku(row + 1, 0))
					return true;
			}
			else if(MakeSudoku(row, col + 1))
				return true;
			
			PutNumberBack(x, row, col);
//			System.out.println("put" + x + " back");
		}


		return false;
		
		
	}
	
	private boolean CompleteSudoku()
	{
		for(int i = 0; i < 9; i++)
			if(!VerticalComplete(i))
				return false;
		for(int i = 0; i < 9; i++)
			if(!HorizontalComplete(i))
				return false;
		for(int i = 0; i < 9; i++)
			if(!SquareComplete(i + 1))
				return false;
		
		return true;
	}
	
	private int[] getAvailable(int row, int col)
	{
		int[] Possible = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(grid[row][i].getNumber() == Possible[j])
					Possible[j] = 0;
					
			}
		}
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				if(grid[i][col].getNumber() > 0 && grid[i][col].getNumber() == Possible[j])
					Possible[j] = 0;
					
			}
		}
		
		for(int r = row / 3 * 3; r <= row / 3 * 3 + 2; r++)
			for(int c = col / 3 * 3; c <= col / 3 * 3 + 2; c++)
				for(int x = 0; x < 9; x++)
				{
//					System.out.println(x + " " + r + "," + c);
					if(grid[r][c].getNumber() > 0 && grid[r][c].getNumber() == Possible[x])
						Possible[x] = 0;
				}
		int index = 0;
		for(int i : Possible)
			if(i > 0)
				index++;
		int[] toreturn = new int[index];
		index = 0;
		for(int i : Possible)
			if(i > 0)
			{
				toreturn[index] = i;
				index++;
			}
		return toreturn;
	}
	private void PutNumber(int num, int row, int col)
	{		
		grid[row][col].setNumber(num);
	}
	private void PutNumberBack(int num, int row, int col)
	{		
		grid[row][col].PutBack();
	}
}
