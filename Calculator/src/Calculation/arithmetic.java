package Calculation;

public class arithmetic {
	
	static double arithmeticCal(double x, double y, char op ) {
		
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
	
	
}
