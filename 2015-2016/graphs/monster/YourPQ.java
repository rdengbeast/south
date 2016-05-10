package monster;

//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class YourPQ
{
	private Queue pQueue;
	private List<Monster> list;


	public YourPQ()
	{

		list = new ArrayList<Monster>();
		list.add(new Monster(0, 0, 0));

	}

//	public void add(Object obj)
//	{
//
//
//	}
	public void add(Monster obj)
	{
//		System.out.println(value);
		list.add(obj);
//		System.out.println("size: " + list.size());
		swapUp(list.size()-1);
		
	}
	public void swapUp(int bot)
	{
//		   if(bot <= 1)
//			   return; 
//		   System.out.println("swapup: " + bot);
		   
		   if(bot > 1 && list.get(bot).compareTo(list.get(bot / 2) ) < 0 )
		   {
			   swap(bot, bot / 2);
			   swapUp(bot / 2);
		   }
	}
	private void swap(int start, int finish)
	{	
//		System.out.println("swap " + start + " with " + finish);
		
		Monster temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}
	
	public Object getMin()
	{
		return list.get(1);
	}
	
//	public Object removeMin()
//	{
//		return "";
//	}
	public Object removeMin( )
	{
		Monster temp;
		temp = list.get(1);
		list.set(1,list.get(list.size()-1));
		list.remove(list.size()-1);
		swapDown(1);
		return temp;
	}
	public void swapDown(int top)
	{
		if(top >= list.size() / 2)
			return;
		
		if( list.get(top * 2).compareTo(list.get(top)) < 0 && list.get(top * 2).compareTo(list.get(top * 2 + 1)) < 0 )
		{
			swap(top, top * 2);
			swapDown(top * 2);
		}
		else if(list.get(top * 2 + 1).compareTo(list.get(top)) < 0 && list.get(top * 2 + 1).compareTo(list.get(top * 2 )) < 0)
		{
			swap(top, top * 2 + 1);
			swapDown(top * 2 + 1);
		}
	}
	public String getNaturalOrder()
	{
		String output="";



		return output;		
	}

	public String toString()
	{
		String output = "";
		for(int i = 1; i < list.size(); i++)
		{
			output += (list.get(i).getHeight() + " " + list.get(i).getWeight() + " " + list.get(i).getAge() + " ,   ");
		}
		return output;
	}
	//write a toString method
	
	
}