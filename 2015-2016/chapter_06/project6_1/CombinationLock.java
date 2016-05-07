package project6_1;

public class CombinationLock {
	
	public boolean lockisopen;
	private char [] lockcombo = new char[3];
	private char [] lockentries = new char[3];
	
	public CombinationLock(char pw1, char pw2, char pw3)
	{
		lockisopen = false;
		char lockcombo2[] = {pw1, pw2, pw3};
		lockcombo = lockcombo2;
	}
	public boolean setLock(char newentry)     
	{

		lockentries[0] = lockentries[1];
		lockentries[1] = lockentries[2];
		lockentries[2] = newentry;
		

		boolean isentrycorrect = true;
		for(int i = 0; i < 3; i++)
		{
			if(lockentries[i] != lockcombo[i] )
				isentrycorrect = false;
		}
		
		lockisopen = isentrycorrect;
		
		return lockisopen;

	}

	public void closeLock()
	{
		lockisopen = false;
	}
}
