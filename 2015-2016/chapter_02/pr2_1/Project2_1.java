package pr2_1;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Project2_1
{
	public static void main(String [] args)
	{
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_WEEK, 100);				
		String calday = days[ cal.get(Calendar.DAY_OF_WEEK) - 1 ];
		cal.add(Calendar.MONTH, 1);					//I must add a month, because eclipse has the date back a month for some reason. Today is 9/6/14, but eclipse says it's 8/6/14
		
		GregorianCalendar mybday = new GregorianCalendar( 1998, Calendar.JUNE, 29 );
		String bdayweekday = days[ mybday.get(Calendar.DAY_OF_WEEK) - 1 ];
		
		System.out.println("100 days from today is: " + cal.get(Calendar.MONTH) + "/" + cal.get( Calendar.DAY_OF_MONTH ) + "/" + cal.get(Calendar.YEAR ) + ", " + calday );
		System.out.println("my birthday is on a: " + bdayweekday);
		
		mybday.add(Calendar.DAY_OF_MONTH, 10000);
		System.out.println("10,000 days from my birthday is: " + mybday.get(Calendar.MONTH) + "/" + mybday.get(Calendar.DAY_OF_MONTH) + "/" + mybday.get(Calendar.YEAR));
		
	}
	
}
