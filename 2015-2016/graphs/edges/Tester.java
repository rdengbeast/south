package edges;

import java.util.Set;
import java.util.TreeSet;

public class Tester {

	public static void main(String[] args) 
	{
		weightedGraph w = new weightedGraph();
		//start, end, speed, distance, cost
		w.addData("ab 1 1 1");
		w.addData("ac 2 1 4");
		w.addData("ad 4 8 9");
		w.addData("bc 2 2 1");
		w.addData("cd 1 2 1");

		Set<Edge>ej = new TreeSet<Edge>();
		System.out.println("yo mama");
		System.out.println(w);
//		ej.add(new Edge("a", 0, 0, 0));
		w.getPaths("a", "d", ej, "");
		System.out.println("cheapest: " + w.cheapest());
		System.out.println("closest: " + w.closest());
		System.out.println("quickest: " + w.quickest());
		// TODO Auto-generated method stub

	}

}
