package exercise6_17;

public class UnitConverter {

	public double startval;
	public boolean isconvertin; //is it converting inches to meters? or nah?
	String startu;
	String endu;
	
	public UnitConverter(double i, boolean isconin, String s, String e)
	{
		startval = i;
		isconvertin = isconin;
		startu = s;
		endu = e;
	}
	public double convert()
	{
		double initialcon;
		double endval;
		if(isconvertin == true)
			initialcon = ( con(startval, startu, true) / 39.3701);
		else
			initialcon = (con(startval, startu, true) / 0.0254);
		
		endval = con(initialcon, endu, false);
		
		return endval;
	}
	public double con(double d, String s, boolean isfirst)
	{
		double returnval = 0;
		if( s.equals("in"))
			returnval = flip(d, 1, isfirst);
		else if( s.equals("ft" ) )
			returnval = flip(d, 12, isfirst );
		else if( s.equals("mi"))
			returnval = flip(d, 63360, isfirst );
		else if( s.equals("mm"))
			returnval = flip(d, (1.0 / 1000), isfirst);
		else if( s.equals("cm"))
			returnval = flip(d, (1.0 / 100), isfirst );
		else if( s.equals("m"))
			returnval = flip(d, 1, isfirst);
		else if( s.equals("km") )
			returnval = flip(d, 1000, isfirst);
		return returnval;
	}
	public static double flip(double d, double i, boolean isfirst)
	{
		double rval = 0;
		if( isfirst == true )
			rval = d * i;
		else
			rval = d / i;
		return rval;
	}
}
