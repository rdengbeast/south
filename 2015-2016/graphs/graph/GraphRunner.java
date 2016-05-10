package graph;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -  

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GraphRunner
{
	public static void main( String[] args ) throws IOException
	{
		String s1 = "";
		Graph p;
		Scanner file = new Scanner(new File("H:/workspace3/BinaryTree/src/graph/graph1.dat"));
		int howManyTimes = file.nextInt();
		file.nextLine();
		for(int x=0; x<howManyTimes; x++)
		{
			p = new Graph(file.nextLine());
			s1 = file.nextLine();
			System.out.println(p);
			System.out.println(s1 + " " +  " " + p.contains(s1) + " " +  p.has() + " " + p.steps());
			
			//add code here
		}
	}
}