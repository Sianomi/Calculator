package postfix;
import java.util.Scanner;
import java.util.Stack;
/*
public class InfixToPostfixMain {

	public static void main(String[] args) {

		InfixToPostfix conv = new InfixToPostfix();
		Scanner sc = new Scanner(System.in);
		String str;
		while (true)
		{
			str = sc.nextLine();
			if (str.equalsIgnoreCase("exit")) break;
			System.out.println(conv.convToExpression(str));
		}
		sc.close();
	}

}
*/


public class InfixToPostfix {
	// ���������ڸ� ���������ڷ� ����
	public String convToExpression(String exp) {

		Stack<Character> stack = new Stack<>();
		int len = exp.length();
		exp += '\0';
		String postFix = "";

		for (int i = 0; i < len; i++) {

			char ch = exp.charAt(i);
			if ((ch >= '0' && ch <= '9') || ch == '.') 
			{

				postFix += ch;
				if((getOpPrec(exp.charAt(i+1))>0) || exp.charAt(i+1) == '\0' || exp.charAt(i+1) == ' ')
				{ 
					postFix += ' '; 
				}
			}
			else if (isLogTri(exp, i))
			{
				int index = exp.indexOf(')',i)+1;
				String logtri = exp.substring(i,index);
				i = index;
				System.out.println(logtri+" ����");
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
						postFix += pop;
						postFix += ' ';
					}
					break;

				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && isProceed(stack.peek(), ch))
					{
						postFix += stack.pop();
						postFix += ' ';
					}
						
					stack.push(ch);
					break;
				}

			}
		}

		while (!stack.isEmpty())
		{
			postFix += stack.pop();
			postFix += ' ';
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
    private boolean isLogTri(String text, int index)
    {
    	if( text.indexOf("Sin",index)==index || text.indexOf("Cos",index)==index || text.indexOf("Tan",index)==index || 
    			text.indexOf("sin",index)==index || text.indexOf("cos",index)==index || text.indexOf("Tan",index)==index)
    		return true;
    	else if(text.indexOf("Log10",index)==index || text.indexOf("Log_e",index)==index || text.indexOf("Pow",index)==index || text.indexOf("Sqrt",index)==index || 
    			text.indexOf("log10",index)==index || text.indexOf("log_e",index)==index || text.indexOf("pow",index)==index || text.indexOf("sqrt",index)==index)
    		return true;
		return false;
    }
}