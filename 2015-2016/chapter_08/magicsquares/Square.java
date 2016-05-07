package magicsquares;

public class Square {
	
	int[][] square = new int[1][1];
	int count;
	
	public Square(int[][] s )
	{
		square = s;
		count = 0;
	}
	public Square(int x)
	{
		square = new int[x][x];
	}
	public void add(int i)
	{
		if(count < square.length * square.length)
		{
			square[count/square.length][count % square.length] = i;
			count++;
		}
		else
		{
			growsquare();
			add(i);
		}
	}
	
	public void growsquare()
	{
		int[][] s = square.clone();
		square = new int[square.length + 1][square.length + 1];
		for(int i = 0; i < s.length; i++)
		{
			for(int x : s[i])
				add(x);
		}
	}
	public boolean isMagic()
	{
		boolean ismagic = true;
		int supposedsum = (square.length * square.length + 1) * square.length / 2;
		int diagonalsum1 = 0;
		int diagonalsum2 = 0;
		for(int j = 0; j < square.length; j++)
		{
			int rowsum = 0;
			for(int x : square[j] )
				rowsum += x;
			if(rowsum != supposedsum)
				ismagic = false;
			System.out.println("rows: " + ismagic);
			int colsum = 0;
			
			for(int k = 0; k < square.length; k++)
			{
				colsum += square[k][j];
				if(j == k)
					diagonalsum1 += square[j][k];
				if(square.length - 1 - k == j)
					diagonalsum2 += square[j][k];
			}
			if(colsum != supposedsum )
				ismagic = false;
			System.out.println("others: " + ismagic);
		}
		if( diagonalsum1 != supposedsum || diagonalsum2 != supposedsum)
			ismagic = false;
		return ismagic;
	}

}
