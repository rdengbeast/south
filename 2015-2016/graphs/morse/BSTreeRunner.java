package morse;


import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
	   BinarySearchTree b = new BinarySearchTree();
	   b.add(90);
	   b.add(80);
	   b.add(100);
	   b.add(70);
	   b.add(85);
	   b.add(98);
	   b.add(120);
	   
	   System.out.println("height: " + b.getHeight());
	   System.out.println("width: " + b.getWidth());
	   System.out.println("leaves: " + b.getNumLeaves());
	   System.out.println("num nodes: " + b.getNumNodes());
	   System.out.println("numlevels: " + b.getNumLevels());
	   System.out.println("tree full: " + b.isFull());
	   System.out.println("toString: " + b);
	   b.remove(80);
	   System.out.println("remove: " + b );
	   
	   b = new BinarySearchTree();
	   b.add(90);
	   b.add(80);
	   b.add(100);
	   b.add(70);
	   b.add(85);
	   b.add(98);
	   b.add(120);
	   
	   b.inOrder();
	   b.preOrder();
	   b.postOrder();
	   b.revOrder();
	   System.out.println("level order: ");
	   b.levelOrder();
	   System.out.println("search for 80");
	   System.out.println(b.search(new TreeNode(80)));
	   System.out.println("search for 1110");
	   System.out.println(b.search(new TreeNode(1110)));
	   System.out.println(b.displayLikeTree());
	   //add test cases here
	   

   }
}