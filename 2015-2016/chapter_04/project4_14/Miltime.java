package project4_14;

public class Miltime {

	private static final int MIN_HOUR = 60;
	private static final int HOURS_DAY = 24;
	
	public String difference(int time1, int time2)
	{

		int minutesdiff;
		
		if( time1 >= time2 )
			minutesdiff = MIN_HOUR*HOURS_DAY - (( (time1 / 100) * MIN_HOUR + time1 % 100) - ((time2 / 100) * MIN_HOUR + time2 % 100 ));
		else
			minutesdiff = ( (time2 / 100) * MIN_HOUR + time2 % 100) - ((time1 / 100) * MIN_HOUR + time1 % 100 );
		
		String diff = (minutesdiff / MIN_HOUR) + " hours, "+ minutesdiff % MIN_HOUR + " minutes";
		return diff;
	}
	
	
}
