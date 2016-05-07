package p18_16;

import java.util.Date;

public class FibonacciTester {
	public static void main(String [] args)
	{
		OptimizedFibonacci o = new OptimizedFibonacci();
		
		Date d = new Date();
		long millis = d.getTime();
		System.out.println(System.currentTimeMillis());
		System.out.println(o.fib(60));
		for(int i = 1; i <= 100000000; i++);
		System.out.println(System.currentTimeMillis());
		System.out.println("time: " + (new Date().getTime() - millis));
		
		long millistwo = new Date().getTime();
		System.out.println(o.fiboriginal(46));
		System.out.println("time: " + (new Date().getTime() - millistwo) );
		
		System.out.println("iterative: " + o.fibiterative(46));
	}
}
