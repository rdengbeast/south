package exercise10_1and10_12;

public class ArcSinApproximater {

	public double getapprox( double angle)
	{
		int i = 3;
		double sum = angle;
		double nxtvalue = (angle) * (angle) * (angle) / 6 ;
		while( nxtvalue >= Math.pow(10, -6))
		{
			sum += nxtvalue;
			i += 2;
			nxtvalue = (i - 2)*(i - 2)*(angle) * (angle) * nxtvalue / i / (i - 1);
		}
		return sum;
	}
}
