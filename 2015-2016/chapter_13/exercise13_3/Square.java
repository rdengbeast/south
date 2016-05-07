package exercise13_3;

public class Square extends java.awt.Rectangle{

	public Square(int xcoord, int ycoord, int sidelength)
	{
		setLocation( xcoord - sidelength / 2, ycoord - sidelength / 2 );
		setSize(new java.awt.Dimension(sidelength, sidelength));
	}
	public double getArea()
	{
		return (getSize().getHeight() * getSize().getWidth() );
	}
}
