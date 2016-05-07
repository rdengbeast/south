package exercise8_11;

public class PermuteTester {

	public static void main(String [] args)
	{
		PermutationGenerator p1 = new PermutationGenerator();
		int[] permuted = p1.nextPermutation();
		for(int i = 0; i < 10; i++)	
			System.out.println(permuted[i]);
	}
}
