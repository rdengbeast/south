package p18_13;

public class DiskMover
{
	public static void main(String[] args)
	{
		move(2, 3, 6);
	}
	
    public static void move(int source, int target, int disks)
    {
        if(disks == 0)
        	System.out.println("done");
        
        else if(disks == 1)
        {
        	System.out.println("move disk from " + source + " to " + target );
        }
        else
        {
        	int empty=6 - target - source;
        	move(source, empty , disks - 1);
        	move(source, target, 1);
        	move(empty , target, disks - 1);
        }
    }
}