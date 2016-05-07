package p18_6;

public class FindLargest
{
	public static void main(String[] args)
	{
		int[] array = {4,1,7,1, 100,0,9,7};
		System.out.println(findLargest(array));
	}
	
	public static int findLargest(int[] a)
	{
		return findLargest(a, 0);
	}
	
	private static int findLargest(int[] a, int start)
	{
		if(start >= a.length)
			return 0;
		int max = findLargest(a, start + 1);
		if(a[start] > max)
			max = a[start];
		return max;
	}
}
