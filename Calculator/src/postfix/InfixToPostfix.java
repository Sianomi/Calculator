package postfix;
import java.util.Stack;
import LogTri.*;

public class InfixToPostfix {
	// ���������ڸ� ���������ڷ� ����
	public Stack<String> convToExpression(String exp) {

		Stack<Character> stack = new Stack<>();
		Stack<String> postFix = new Stack<String>();
		Stack<String> postFixTemp = new Stack<String>();
		StringBuilder temp = new StringBuilder();
		LogTri.trigonometrical logTri = new LogTri.trigonometrical();

		int len = exp.length();
		exp = exp.toLowerCase()+'\0';

		for (int i = 0; i < len; i++) {

			char ch = exp.charAt(i);
			if ((ch >= '0' && ch <= '9') || ch == '.') 
			{

				temp.append(ch);
				if((getOpPrec(exp.charAt(i+1))>0) || exp.charAt(i+1) == '\0' || exp.charAt(i+1) == ' ')
				{ 
					postFix.push(temp.toString());
					temp.setLength(0);
				}
			}
			else if (logTri.isLogTri(exp, i))
			{
				int index = exp.indexOf(')',i);
				String logtri = exp.substring(i,index+1);
				i = index;
				
				index = logtri.indexOf('(');
				String logtriOp = logtri.substring(0,index);
				logtri = logtri.substring(index+1,logtri.indexOf(')',index));
				postFixTemp = convToExpression(logtri);
				double one = calPostfix(postFixTemp);
				double two = logTri.Calculation(one, logtriOp);
				postFix.push(Double.toString(two));
			}
			else
			{

				switch (ch) {

				case '(':
					stack.push(ch);
					break;

				case ')':
					while (true) {
						char pop = stack.pop();
						if (pop == '(')
							break;
						postFix.push(String.valueOf(pop));
					}
					break;

				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && isProceed(stack.peek(), ch))
					{
						postFix.push(String.valueOf(stack.pop()));
					}
						
					stack.push(ch);
					break;
				}

			}
		}

		while (!stack.isEmpty())
		{
			postFix.push(String.valueOf(stack.pop()));
		}
			

		return postFix;

	}

	// �������� �켱������ ��ȯ�ϴ� �޼ҵ�
	public int getOpPrec(char op) {

		switch (op) {
		case '*':
		case '/':
			return 5;

		case '+':
		case '-':
			return 3;

		case '(':
		case ')':
			return 1;
		}
		return -1;
	}

	// op1�� �켱������ ������ true, ������ false�� ��ȯ
	public boolean isProceed(char op1, char op2) {

		int op1Prec = getOpPrec(op1);
		int op2Prec = getOpPrec(op2);

		if (op1Prec >= op2Prec)
			return true;
		else
			return false;
	}
	
	public double calPostfix(Stack<String> textPitches)
	{
		Stack<Double> doubleStack = new Stack<Double>();
		if(textPitches.size()>1)
		{
			for(String temp : textPitches)
	    	{
	    		if(Calculation.arithmetic.isArithmetic(temp.charAt(0)) && temp.length()==1)
	    		{
	    			double second = doubleStack.pop();
	    			double first = doubleStack.pop();
	    			doubleStack.push(Calculation.arithmetic.arithmeticCal(
	    					first, second , temp.charAt(0)));
	    			continue;
	    		}
				doubleStack.push(Double.parseDouble(temp));
	    	}
		}
		else
			doubleStack.push(Double.parseDouble(textPitches.get(0)));
		return doubleStack.get(0);
	}
}