package exercise6_18;
import java.awt.geom.Point2D;

public class Line {

	private double slope;
	private double yint;
	private double vertlinexint;
	private boolean isvert;
	public Line(Point2D initialpoint, double slope)
	{
		this.slope = slope;
		yint = initialpoint.getY() - slope * initialpoint.getX();
		isvert = false;
	}
	public Line(Point2D point1, Point2D point2)
	{
		slope = (point1.getY() - point2.getY() ) / (point1.getX() - point2.getX() );
		yint = point1.getY() - slope * point1.getX();
		isvert = false;
	}
	public Line(String equation )
	{
		constructorhelper(equation);
	}
	public Line(String equation, boolean isvertical)
	{
		if(isvertical == true)
		{
			vertlinexint = Double.parseDouble(equation.substring(4) );
			isvert = isvertical;
		}
		else
			constructorhelper(equation);
	}
	private void constructorhelper( String equation )
	{
		int mendpos = equation.indexOf("x");
		slope = Double.parseDouble( equation.substring(4, mendpos ) );
		yint = Double.parseDouble(equation.substring(mendpos + 4, equation.length() ) );
		isvert = false;
	}
	
	public boolean intersects(Line other)
	{
		boolean doesintersect;
		if( !isclosenuf( slope, other.slope) )
			doesintersect = true;
		else
			doesintersect = false;
		return doesintersect;
	}
	public boolean equals(Line other)
	{
		boolean doesequal = false;
		if(isvert == false)
		{
			if( isclosenuf(slope, other.slope) && isclosenuf(yint, other.yint) )
				doesequal = true;
			else
				doesequal = false;
		}
		else if ( isclosenuf( vertlinexint, other.vertlinexint) ) 
			doesequal = true;
		
		return doesequal;
	}
	public boolean isParallel(Line other)
	{
		boolean isll = false;
		if(isvert == false)
		{
			if( isclosenuf( slope, other.slope) )
				isll = true;
			else
				isll = false;
		}
		else if( !isclosenuf( vertlinexint, other.vertlinexint) )
			isll = true;
		return isll;
	}
	public static boolean isclosenuf(double n1, double n2)
	{
		boolean iscloseenough;
		if(Math.abs(n1 - n2) <= 0.00001)
			iscloseenough = true;
		else
			iscloseenough = false;
		return iscloseenough;
	}
	public String toString()
	{
		String retstr;
		if( !isvert)
			retstr = "y = " + slope + " x + " + yint;
		else
			retstr = "x = " + vertlinexint;
		return retstr;
	}
}
