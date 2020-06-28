package LogTri;

public class trigonometrical {
	public double Calculation (double x, String op)
	{	
		double result = 0.0;
		if(op.equalsIgnoreCase("sin"))
		{   
			result = Math.sin(Math.toRadians(x));
		}
		else if(op.equalsIgnoreCase("cos"))
		{
			
			result = Math.cos(Math.toRadians(x));
		}
		
		else if(op.equalsIgnoreCase("tan"))

		{
			if(x % 90 == 0 && x != 0 && x % 180 != 0)
				result = Double.NaN;
			else
			{
				x %= 90;
				result = Math.tan(Math.toRadians(x));
			}
		}
		
		else if(op.equalsIgnoreCase("log10"))
		{
			result =  Math.log10(x);
		}
		
		else if(op.equalsIgnoreCase("log_e"))
		{
			result = Math.log(x);
		}
		else if(op.equalsIgnoreCase("sqrt"))
		{
			result = Math.sqrt(x);
		}
		return result;
	}
	public double Calculation(double x, double y, String op)
	{
		double result = 0.0;
		result = Math.pow(x, y);
		return result;
	}
    public boolean isLogTri(String text, int index)
    {
    	if(text.indexOf("sin",index)==index || text.indexOf("cos",index)==index || text.indexOf("tan",index)==index)
    		return true;
    	else if(text.indexOf("log10",index)==index || text.indexOf("log_e",index)==index || text.indexOf("pow",index)==index || text.indexOf("sqrt",index)==index)
    		return true;
		return false;
    }
}
	
