package exercise8_11;

public class PermutationGenerator {
private int[] randperm = new int[10];
private int[]onetoten = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	public int[] nextPermutation()
	{
		int[] randperm = new int[10];
		
		int numsleft = 10;
		for(int i = 0; i < 10; i++)
		{
			int indexchosen = (int)(Math.random() * numsleft );
			randperm[i] = onetoten[indexchosen];
			swap(indexchosen, numsleft - 1);
			numsleft--;
			
		}
		return randperm;
	}
	public void swap(int i, int j)
	{
		int[]temp = onetoten;
		onetoten[i] = temp[j];
		onetoten[j] = temp[i];
	}
}
