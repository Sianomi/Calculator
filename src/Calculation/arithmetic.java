package Calculation;

public class arithmetic {
	
	public static double arithmeticCal(double x, double y, char op ) {
		
		double result=0;
		
		switch(op) {
		
		case '+':
			result = x + y;
			break;
		case '-':
			result = x - y;
			break;
		case '*':
			result = x * y;
			break;
		case '/':
			result = x / y;
			break;
		}
		
		return result;
	}
	
	public static boolean isArithmetic(char op)
	{
		if(op == '+' || op == '-' || op == '*' || op == '/')
			return true;
		return false;	
	}
}
