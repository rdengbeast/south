package morse;


public class BalancedTree extends BinarySearchTree
{
	public BalancedTree (Morse[] data)
	{
		setRoot(balance(data));
	}
	public TreeNode balance(Morse[] data)
	{
		return balance(data, 0, data.length - 1);
	}
	private TreeNode balance(Morse[] data, int b, int c)
	{
		if(b >= c)
			return new TreeNode(data[b]);
		
		int average = (b + c) / 2;
		
		TreeNode toreturn = new TreeNode(data[average]);
		toreturn.setLeft(balance(data, b, average - 1));
		toreturn.setRight(balance(data, average + 1, c));
		return toreturn;
	}
//	public static void main(String[] args)
//	{
//		int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
//		BalancedTree x = new BalancedTree(data);
//		System.out.println("In Order");
//		x.inOrder();
//		TreeNode temp = x.getRoot();
//		System.out.println("Right Branch");
//		while(temp != null)
//		{
//			System.out.println(temp + " ");
//			temp = temp.getRight();
//		}
//	}
}
