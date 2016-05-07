package magicsquares;

public class MagicSquares {
	int[][] x = new int[1][1];
	public MagicSquares(int n)
	{
		x = new int[n][n];
		int count = 1;
		if(n % 2 == 1)
		{
			x[n - 1][n / 2 ] = 1;
			count++;
			int rownum = n - 1;
			int colnum = n / 2;
			while(count <= n * n)
			{
				
				if( x[(rownum + 1) % n][(colnum + 1 )% n] == 0 && rownum + colnum != 2 * n - 2)
				{
					rownum = (rownum + 1) % n;
					colnum = (colnum + 1 )% n;
					x[rownum][colnum] = count;
					System.out.println("hi");
				}
				else
				{
					if(rownum == 0)
						rownum = n - 1;
					else
						rownum = (rownum - 1) % n;
					x[rownum][colnum] = count;
					System.out.println("cool");
				}
				count++;
			}
		}
	}
	public String toString()
	{
		String retstring = "";
		for(int[] a : x)
		{
			for(int i : a)
				retstring += (i + "\t");
			retstring += "\n";
		}
		return retstring;
	}
}
