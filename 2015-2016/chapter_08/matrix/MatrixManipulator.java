package matrix;

/**
 * Offers the specified operations on integer matrices.
 */
public class MatrixManipulator
{
	/**
	 * Determines if (first + second) is defined where + indicates matrix addition.
	 * 
	 * @return true if matrix addition is defined, false otherwise.
	 */
	public static boolean addable(int[][] first, int[][] second)
	{
		boolean addable = true;
		if(first.length != second.length )
			addable = false;
		for(int i = 0; i < first.length; i++)
		{
			if(first[i].length != second[i].length)
				addable = false;
		}
		return addable; // remove this
	}

	/**
	 * Performs (first + second) where + indicates matrix addition. (Precondition: addable(first, second) returns true.)
	 * 
	 * @return the result of first + second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] add(int[][] first, int[][] second)
	{
		int[][] retarray = new int[first.length][first[0].length];
		if( !addable(first, second) )
			throw new IllegalArgumentException();
		else
		{
			for(int i = 0; i < retarray.length; i++)
			{
				for(int j = 0; j < first[i].length; j++)
					retarray[i][j] = first[i][j] + second[i][j];
			}
		}
		return retarray; // remove this
	}

	/**
	 * Performs (scalar * matrix) where * indicates scalar multiplication of a matrix. (Precondition: matrix.length > 0 && matrix[0].length > 0)
	 * 
	 * @return the result of scalar * matrix.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiplyByScalar(int scalar, int[][] matrix)
	{
		int[][] returnedarray = new int[matrix.length][matrix[0].length];
		if(matrix.length > 0 && matrix[0].length > 0)
		{
			for(int i = 0; i < matrix.length; i++)
			{
				for(int j = 0; j < matrix[i].length; j++ )
					returnedarray[i][j] = matrix[i][j] * scalar;
			}
		}
		else
		{
			throw new IllegalArgumentException();
		}
		return returnedarray; // remove this
	}

	/**
	 * Multiplies the specified row of first and the specified column of second. (Precondition: first[row].length > 0 && first[row].length == second.length)
	 * 
	 * @return the result of multipliying the specified row and column.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int multiply(int[][] first, int row, int[][] second, int col)
	{
		int sum = 0;

		if(first[row].length > 0 && first[row].length == second.length)
		{
			for(int i = 0; i < first[row].length; i++)
			{
				sum += first[row][i] * second[i][col];
			}
		}
		else
			throw new IllegalArgumentException();
		return sum; // remove this
	}

	/**
	 * Determines if (first * second) is defined where * indicates matrix multiplication.
	 * 
	 * @return true if matrix multiplication is defined, false otherwise.
	 */
	public static boolean multipliable(int[][] first, int[][] second)
	{
		boolean canmultiply = true;
		for(int i = 0; i < first.length; i++)
		{
			if(first[i].length != second.length)
				canmultiply = false;
		}
		return canmultiply; // remove this
	}

	/**
	 * Performs (first * second) where * indicates matrix multiplication. (Precondition: multipliable(first, second) returns true.)
	 * 
	 * @return the result of first * second.
	 * @throws IllegalArgumentException
	 *             if the precondition is not met.
	 */
	public static int[][] multiply(int[][] first, int[][] second)
	{
		int[][] product = new int[first.length][second[0].length];
		
		if(multipliable(first, second) )
		{
			for(int i = 0; i < first.length; i++)
			{
				for(int j = 0; j < second[i].length; j++)
					product[i][j] = multiply(first, i, second, j);
			}
		}
		else
			throw new IllegalArgumentException();
		
		return product; // remove this
	}

	private static boolean atLeastOneByOne(int[][] matrix)
	{
		return matrix != null && matrix.length > 0 && matrix[0].length > 0;
	}
}
