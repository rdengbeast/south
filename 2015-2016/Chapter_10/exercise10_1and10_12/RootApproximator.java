package exercise10_1and10_12;

public class RootApproximator
{
    private double a;
    private double x0;
    private double x1;
    
    public RootApproximator(double aNumber)
    {
        a = aNumber;
        x1 = aNumber;
    }
    
    public double nextGuess()
    {
    	x0 = x1;
        x1 = (x1 + a / x1) / 2;

        return x0;
    }
    
    public double getRoot()
    {
        while(!Numeric.approxEqual(x0, x1))
            nextGuess();
        return x1;
    }

}
