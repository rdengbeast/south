package morse;


import static java.lang.System.*;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

//import phone.PhoneEntry2;

public class BinarySearchTree
{
	public TreeNode root;

	public TreeNode getRoot()
	{
		return root;
	}
	public void setRoot(TreeNode tree)
	{
		root = tree;
	}
	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
//		System.out.println(val);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   if(tree == null)
	   {
			tree = new TreeNode(val);
			return tree;
	   }
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;
	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null)
		{
			inOrder(tree.getLeft());
			System.out.println(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	public void preOrder()
	{
		preOrder(root);
		System.out.println("\n\n");
	}
	private void preOrder(TreeNode tree)
	{
		if (tree != null)
		{
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	public void postOrder()
	{
		postOrder(root);
		System.out.println("\n\n");
	}
	private void postOrder(TreeNode tree)
	{
		if (tree != null)
		{
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");

		}
	}
	public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}
	private void revOrder(TreeNode tree)
	{
		if (tree != null)
		{
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}
	
	//add preOrder, postOrder, and revOrder
	//done
	
	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		int a = getNumLevels(tree.getLeft());
		int b = getNumLevels(tree.getRight());
		if(a > b)
			return a + 1;
		return b + 1;
//		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
//			return 1+getNumLevels(tree.getLeft());
//		else
//			return 1+getNumLevels(tree.getRight());
	}

	public int getNumNodes()
	{
		return getNumNodes(root);
	}
	private int getNumNodes(TreeNode tree)
	{
		if(tree==null)
			return 0;
		return getNumNodes(tree.getLeft()) + 1 + getNumNodes(tree.getRight());
	}
	
	public int getNumLeaves()
	{
		return getNumLeaves(root) / 2;
	}
	private int getNumLeaves(TreeNode tree)
	{
		if(tree==null)
			return 1;
		return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
	}
	
	public int getWidth()
	{
		return getWidth(root);
	}
	private int getWidth(TreeNode tree)
	{
		if(tree == null)
			return 0;
		int a = getNumLevels(tree.getLeft()) + getNumLevels(tree.getRight()) + 1;
		int b = getWidth(tree.getLeft());
		int c = getWidth(tree.getRight());
		if(a > b)
		{
			if(a > c)
				return a;
			return c;
		}
		if(b > c)
			return b;
		return c;
	}
	public int getHeight()
	{
		return getNumLevels() - 1;
	}
	public boolean isFull()
	{
		return isFull(root);
	}
	private boolean isFull(TreeNode tree)
	{
		if(tree.getLeft() == null && tree.getRight() == null)
			return true;
		if(tree.getLeft() == null)
			return false;
		if(tree.getRight() == null)
			return false;
		return isFull(tree.getLeft()) && isFull(tree.getRight());
	}
	//add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull
	
	public boolean search(TreeNode toSearch)
	{
		return search(root, toSearch);
	}
	private boolean search(TreeNode tree, TreeNode toSearch)
	{
		if(tree == null)
			return false;
		if(tree.getValue().equals(toSearch.getValue()))
			return true;
		if(tree.getValue().compareTo(toSearch.getValue()) < 0)
			return search(tree.getRight(), toSearch);
		return search(tree.getLeft(), toSearch);
	}
	
//	public Comparable search2(String x)
//	{
//		TreeNode toSearch = new TreeNode(new PhoneEntry2("", x));
//		return search2(root, toSearch);
//	}
//	private Comparable search2(TreeNode tree, TreeNode toSearch)
//	{
//		if(tree == null)
//			return null;
//		if( ((PhoneEntry2)(tree.getValue())).getNumber().equals(((PhoneEntry2)(toSearch.getValue())).getNumber()) )
//			return tree.getValue();
//		if(((PhoneEntry2)(tree.getValue())).getNumber().compareTo(((PhoneEntry2)(toSearch.getValue())).getNumber()) < 0)
//			return search2(tree.getRight(), toSearch);
//		return search2(tree.getLeft(), toSearch);
//	}
//	
//	public Comparable search3(String x)
//	{
//		TreeNode toSearch = new TreeNode(new PhoneEntry2(x , ""));
//		return search3(root, toSearch);
//	}
//	private Comparable search3(TreeNode tree, TreeNode toSearch)
//	{
//		if(tree == null)
//			return null;
//		if( ((PhoneEntry2)(tree.getValue())).getName().equals(((PhoneEntry2)(toSearch.getValue())).getName()) )
//			return tree.getValue();
//		if(((PhoneEntry2)(tree.getValue())).getName().compareTo(((PhoneEntry2)(toSearch.getValue())).getName()) < 0)
//			return search3(tree.getRight(), toSearch);
//		return search3(tree.getLeft(), toSearch);
//	}
	public TreeNode maxNode()
	{
		TreeNode temp = root;
		while(temp.getRight() != null)
		{
			temp = temp.getRight();
		}
		return temp;
	}
	public TreeNode minNode()
	{
		TreeNode temp = root;
		while(temp.getLeft() != null)
		{
			temp = temp.getLeft();
		}
		return temp;
	}
	
	public void remove(Comparable val)
	{
		root = remove(val, root);
	}
	private TreeNode remove(Comparable val, TreeNode tree)
	{
		if(tree!= null)
		{
			int dirTest = val.compareTo(tree.getValue());
			
			if(dirTest < 0)
				tree.setLeft(remove(val, tree.getLeft()));
			else if(dirTest > 0)
				tree.setRight(remove(val, tree.getRight()));
			else
			{
				if(tree.getRight() == null)
					tree = tree.getLeft();
				else
				{
					TreeNode successor = getSmallest(tree.getRight());
					tree.setValue((successor.getValue()));
					tree.setRight(remove(successor.getValue(), tree.getRight()));
				}
			}
		}
		return tree;
	}
	public Comparable getSmallest()
	{
		return getSmallest(root).getValue();
	}
	private TreeNode getSmallest(TreeNode tree)
	{
		if(tree != null)
		{
			if(tree.getLeft() != null)
				return getSmallest(tree.getLeft());
			else
				return tree;
		}
		return null;
	}
	
	public void levelOrder()
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		System.out.println(levelOrder(root, q));
	}
	private Queue<TreeNode> levelOrder(TreeNode tree, Queue<TreeNode> q)
	{
		if(tree != null)
		{
			if(tree.getRight() != null && tree.getLeft() != null)
			{
				q.add(tree.getLeft());
				q.add(tree.getRight());
				levelOrder(tree.getLeft(), q);
				levelOrder(tree.getRight(), q);
			}
		}
		
		return q;
	}
	
	public String displayLikeTree()
	{
		String output = "";
		
		Queue<String> q = new LinkedList<>();
		q.add(root.toString());
		displayLikeTree(root, q);
		
		int nextSpaceIndex = 1;
		int size = q.size();
		for (int i = 0; i < size; i++)
		{	
			if (i == nextSpaceIndex)
			{
				output += "\n";
				nextSpaceIndex *= 2;
			}
			
			output += q.remove() + "\t";
		}
		
		return output;
	}
	
	private Queue<String> displayLikeTree(TreeNode tree, Queue<String> q)
	{
		if(tree != null)
		{

			if(tree.getRight() != null && tree.getLeft() != null)
			{
				q.add(tree.getLeft().toString());
				q.add(tree.getRight().toString());
				displayLikeTree(tree.getLeft(), q);
				displayLikeTree(tree.getRight(), q);
			}

		}
		
		return q;
	}
	public String toString()
	{
		//return "";
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
		
		if (tree != null)
		{
			return toString(tree.getLeft()) + (tree.getValue() + " ") + toString(tree.getRight());
		}
		return "";
	}
}