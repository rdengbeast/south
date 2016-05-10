package heaps;

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap
{
	private List<Integer> list;

	public Heap()
	{
		list = new ArrayList<Integer>();
		list.add(0);
	}

	public void add(int value)
	{
		System.out.println(value);
		list.add(value);
		System.out.println("size: " + list.size());
		swapUp(list.size()-1);
		
	}

   public void swapUp(int bot)
   {
//	   if(bot <= 1)
//		   return; 
//	   System.out.println("swapup: " + bot);
	   
	   if(bot > 1 && list.get(bot) > list.get(bot / 2) )
	   {
		   swap(bot, bot / 2);
		   swapUp(bot / 2);
	   }
   }

	public void remove( )
	{
		list.set(1,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(1);
	}

	public void swapDown(int top)
	{
		if(top >= list.size() / 2)
			return;
		
		if(list.get(top * 2) > list.get(top) && list.get(top * 2) > list.get(top * 2 + 1) )
		{
			swap(top, top * 2);
			swapDown(top * 2);
		}
		else if(list.get(top * 2 + 1) > list.get(top) && list.get(top * 2 + 1) > list.get(top * 2 ))
		{
			swap(top, top * 2 + 1);
			swapDown(top * 2 + 1);
		}
	}
	
	private void swap(int start, int finish)
	{	
		System.out.println("swap " + start + " with " + finish);
		
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	public void print()
	{
		out.println("\n\nPRINTING THE HEAP!\n\n");
		out.println();
		int temp = 1;
		for(int i = 0; i < list.size(); i++)
		{
			if(i != 0)
			{
				if(i < temp)
					System.out.print(list.get(i) + " ");
				else
				{
					System.out.println();
					temp = temp * 2;
					System.out.print(list.get(i) + " ");
				}
			}
		}
	}

	public String toString()
	{
		return list.toString();
	}
}