package p18_16;
import java.util.Date;
import java.util.ArrayList;
public class OptimizedFibonacci {

	public int fib(int number)
	{
		if(number == 0)
		{
			fibnumbers.set(0, 0);
			return 0;
		}
		if(number == 1)
		{
			if(fibnumbers.size() > 0)
				fibnumbers.set(1, 1);
			else
				fibnumbers.add(1);
			return 1;
		}
		
		if(number <= fibnumbers.size())
			return fibnumbers.get(number - 1);
		else
		{
			int x = fib(number - 1) + fib(number - 2);
			fibnumbers.add(x);
			return x;
		}
	}
	private ArrayList<Integer> fibnumbers = new ArrayList<Integer>();

	public int fiboriginal(int number)
	{
		if(number == 0)
		{
			return 0;
		}
		if(number == 1)
		{
			return 1;
		}
		
		return fib(number - 1) + fib(number - 2);
	}

	public int fibiterative(int number)
	{
		ArrayList<Integer> fibs = new ArrayList<Integer>();
		fibs.add(0);
		fibs.add(1);
		for(int i = 2; i <= number; i++)
			fibs.add(fibs.get(i - 2) + fibs.get(i - 1));
		return fibs.get(number);
	}
}
