package LogTri;

public class trigonometrical {
	public static double Calculation (double x, String op)
	{	
		double result;
		if(op.equalsIgnoreCase("sin"))
		{   
			Math.toDegrees(x);
			result = Math.sin(x);
		}
		else if(op.equalsIgnoreCase("cos"))
		{
			Math.toDegrees(x);
			result = Math.cos(x);
		}
		
		else if(op.equalsIgnoreCase("tan"))

		{
			Math.toDegrees(x);
			result = Math.tan(x);
		}
		
		else if(op.equalsIgnoreCase("log10"))
		{
			result =  Math.log10(x);
		}
		
		else if(op.equalsIgnoreCase("log_e"))
		{
			result = Math.exp(x);
		}
				
		return result;
	}
}
	
