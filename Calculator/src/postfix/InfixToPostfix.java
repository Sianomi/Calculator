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
			if ((ch >= '0' && ch <= '9') || ch == '.') {

				postFix += ch;
				if((getOpPrec(exp.charAt(i+1))>0) || exp.charAt(i+1) == '\0' || exp.charAt(i+1) == ' ')
				{ 
					postFix += ' '; 
				}
			} else {

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
}