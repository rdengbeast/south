package Exercise3_11;

public class SodaCan {
	private double height;
	private double radius;
	public SodaCan()
	{
		height = 10;
		radius = 5;
	}
	public double getSurfaceArea()
	{
		double sa = height * radius * 2 * Math.PI + 2 * Math.PI * radius * radius;
		return sa;
	}
	public double getVolume()
	{
		double vo = height * radius * radius * Math.PI;
		return vo;
	}
}
