package exercise_14;
public class Rounding {

	public static boolean round(float a, float b)
	{
		float a2 = a * 100;
		float b2 = b * 100;
		if(Math.round(a2) == Math.round(b2))
			return true;
		else
			return false;
	}
}
