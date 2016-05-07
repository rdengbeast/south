package project4_1;

public class Triangle {


	int[] tripts = new int[6];
	
	public Triangle( int ax, int ay, int bx, int by, int cx, int cy)
	{
		tripts[0] = ax;
		tripts[1] = ay;
		tripts[2] = bx;
		tripts[3] = by;
		tripts[4] = cx;
		tripts[5] = cy;
	}
	
	public static double distance( int x1, int y1, int x2, int y2)
	{
		double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2) );
		return distance;
	}
	
	public double getSides( char side)
	{
		double sidewanted = 0;
		if(side == 'a')
			sidewanted = distance(tripts[2], tripts[3], tripts[4], tripts[5]);
		if(side == 'b')
			sidewanted = distance(tripts[0], tripts[1], tripts[4], tripts[5] );
		if(side == 'c')
			sidewanted = distance(tripts[0], tripts[1], tripts[2], tripts[3] );
		return sidewanted;
	}
	
	public double perimeter()
	{
		double perim = 0;
		perim = this.getSides('a') + this.getSides('b') + this.getSides('c');
		
		return perim;
	}
	
	public double area()
	{
		double semiperim = this.perimeter() / 2;
		double area = 0;
		area = Math.sqrt( semiperim 
				* (semiperim - this.getSides('a') ) 
				* (semiperim - this.getSides('b') ) 
				* (semiperim - this.getSides('c') ) );
		
		if( Math.abs( Math.round(area) - area ) <= 0.0001 )
			area = Math.round(area);
		return area;
	}
	
	public double[] angles()
	{
		double[] angarray = new double[3];
		
		angarray[0] = Math.acos( (Math.pow( this.getSides('c') , 2) + Math.pow( this.getSides('b'), 2 ) - Math.pow( this.getSides('a') , 2) ) 
				/ ( 2 * this.getSides('c') * this.getSides('b' ) ) ) * (180/ Math.PI) ; 
		
		angarray[1] = Math.acos( (Math.pow( this.getSides('a') , 2) + Math.pow( this.getSides('c'), 2 ) - Math.pow( this.getSides('b') , 2) )
				/ ( 2 * this.getSides('a') * this.getSides('c' ) ) ) * (180/ Math.PI) ; 
		
		angarray[2] = Math.acos( (Math.pow( this.getSides('a') , 2) + Math.pow( this.getSides('b'), 2 ) - Math.pow( this.getSides('c') , 2) )
				/ ( 2 * this.getSides('a') * this.getSides('b' ) ) ) * (180/ Math.PI) ; 
		for(int i = 0; i < 3; i++)
		{
			if(angarray[i] - (int)angarray[i] <= 0.00001)
				angarray[i] = (int)(angarray[i]);
		}
		return angarray;
	}
}
