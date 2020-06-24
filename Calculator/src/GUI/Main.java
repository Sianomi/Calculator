package GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import postfix.*;
import Calculation.*;


public class Main {

	private JFrame frame;
	private JTextField Text;
	private JButton btn7;
	private JPanel keypad;
	private JButton btn9;
	private JButton btn8;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn1;
	private JButton btn3;
	private JButton btnDot;
	private JButton btn2;
	private JButton btn0;
	private JButton btnEnter;
	private JButton btnSin;
	private JButton btnCos;
	private JPanel Feature;
	private JButton btnTan;
	private JButton btnLog10;
	private JButton btnLog_e;
	private JButton btnDel;
	private JButton btnOpenParenthesis;
	private JButton btnCloseParenthesis;
	private JButton btnPow;
	private JButton btnSqrt;
	private JButton btnClear;
	private JButton btnHistory;
	private JButton btnDevide;
	private JButton btnMinus;
	private JButton btnCross;
	private JButton btnPlus;
	private JPanel Operations;
	private JButton btnAlgorithm;
	private History dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\uACF5\uD559\uC6A9\uACC4\uC0B0\uAE30");
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 679, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Text = new JTextField();
		Text.setCaretColor(new Color(255, 255, 255));
		
		Text.setBorder(null);
		Text.setBackground(Color.BLACK);
		Text.setForeground(new Color(255, 255, 255));
		Text.setFont(new Font("±¼¸²", Font.PLAIN, 32));
		Text.setBounds(0, 0, 663, 76);
		frame.getContentPane().add(Text);
		Text.setColumns(10);
		
		keypad = new JPanel();
		keypad.setBounds(0, 164, 495, 305);
		frame.getContentPane().add(keypad);
		keypad.setLayout(new GridLayout(0, 3, 0, 0));
		
		btn7 = new JButton("7");
		btn7.addActionListener(new EventHandlerKeypad());
		btn7.setBackground(new Color(0, 0, 51));
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new EventHandlerKeypad());
		btn8.setBackground(new Color(0, 0, 51));
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new EventHandlerKeypad());
		btn9.setBackground(new Color(0, 0, 51));
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn9);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new EventHandlerKeypad());
		btn4.setBackground(new Color(0, 0, 51));
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new EventHandlerKeypad());
		btn5.setBackground(new Color(0, 0, 51));
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new EventHandlerKeypad());
		btn6.setBackground(new Color(0, 0, 51));
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn6);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new EventHandlerKeypad());
		btn1.setBackground(new Color(0, 0, 51));
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new EventHandlerKeypad());
		btn2.setBackground(new Color(0, 0, 51));
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new EventHandlerKeypad());
		btn3.setBackground(new Color(0, 0, 51));
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn3);
		
		btnDot = new JButton(".");
		btnDot.addActionListener(new EventHandlerKeypad());
		btnDot.setBackground(new Color(0, 0, 51));
		btnDot.setForeground(new Color(255, 255, 255));
		btnDot.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btnDot);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new EventHandlerKeypad());
		btn0.setBackground(new Color(0, 0, 51));
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btn0);
		
		btnEnter = new JButton("=");
		btnEnter.addActionListener(new EventHandlerEnter());
		btnEnter.setBackground(new Color(0, 0, 51));
		btnEnter.setForeground(new Color(255, 255, 255));
		btnEnter.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		keypad.add(btnEnter);
		
		Feature = new JPanel();
		Feature.setBorder(null);
		Feature.setBounds(0, 86, 663, 66);
		frame.getContentPane().add(Feature);
		Feature.setLayout(new GridLayout(0, 6, 0, 0));
		
		btnSin = new JButton("Sin");
		btnSin.addActionListener(new EventHandlerFeature());
		btnSin.setForeground(new Color(255, 255, 255));
		btnSin.setBackground(new Color(102, 102, 102));
		Feature.add(btnSin);
		
		btnCos = new JButton("Cos");
		btnCos.addActionListener(new EventHandlerFeature());
		btnCos.setForeground(new Color(255, 255, 255));
		btnCos.setBackground(new Color(102, 102, 102));
		Feature.add(btnCos);
		
		btnTan = new JButton("Tan");
		btnTan.addActionListener(new EventHandlerFeature());
		btnTan.setForeground(new Color(255, 255, 255));
		btnTan.setBackground(new Color(102, 102, 102));
		Feature.add(btnTan);
		
		btnLog10 = new JButton("Log10");
		btnLog10.addActionListener(new EventHandlerFeature());
		btnLog10.setForeground(new Color(255, 255, 255));
		btnLog10.setBackground(new Color(102, 102, 102));
		Feature.add(btnLog10);
		
		btnLog_e = new JButton("Log_e");
		btnLog_e.addActionListener(new EventHandlerFeature());
		btnLog_e.setForeground(new Color(255, 255, 255));
		btnLog_e.setBackground(new Color(102, 102, 102));
		Feature.add(btnLog_e);
		
		btnAlgorithm = new JButton("Algorithm");
		btnAlgorithm.setForeground(new Color(255, 255, 255));
		btnAlgorithm.setBackground(new Color(102, 102, 102));
		Feature.add(btnAlgorithm);
		
		btnOpenParenthesis = new JButton("(");
		btnOpenParenthesis.addActionListener(new EventHandlerKeypad());
		btnOpenParenthesis.setForeground(new Color(255, 255, 255));
		btnOpenParenthesis.setBackground(new Color(102, 102, 102));
		Feature.add(btnOpenParenthesis);
		
		btnCloseParenthesis = new JButton(")");
		btnCloseParenthesis.addActionListener(new EventHandlerKeypad());
		btnCloseParenthesis.setForeground(new Color(255, 255, 255));
		btnCloseParenthesis.setBackground(new Color(102, 102, 102));
		Feature.add(btnCloseParenthesis);
		
		btnPow = new JButton("Pow");
		btnPow.addActionListener(new EventHandlerFeature());
		btnPow.setForeground(new Color(255, 255, 255));
		btnPow.setBackground(new Color(102, 102, 102));
		Feature.add(btnPow);
		
		btnSqrt = new JButton("Sqrt");
		btnSqrt.addActionListener(new EventHandlerFeature());
		btnSqrt.setForeground(new Color(255, 255, 255));
		btnSqrt.setBackground(new Color(102, 102, 102));
		Feature.add(btnSqrt);
		
		btnHistory = new JButton("HISTORY");
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog = new History();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnHistory.setForeground(new Color(255, 255, 255));
		btnHistory.setBackground(new Color(102, 102, 102));
		Feature.add(btnHistory);
		
		btnDel = new JButton("DEL");
		btnDel.addActionListener(new EventHandlerRemove());
		btnDel.setForeground(new Color(255, 255, 255));
		btnDel.setBackground(new Color(102, 102, 102));
		Feature.add(btnDel);
		
		Operations = new JPanel();
		Operations.setBounds(496, 164, 167, 305);
		frame.getContentPane().add(Operations);
		Operations.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Text.setText("");
			}
		});
		btnClear.setBackground(Color.ORANGE);
		btnClear.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		Operations.add(btnClear);
		
		btnCross = new JButton("*");
		btnCross.addActionListener(new EventHandlerKeypad());
		btnCross.setBackground(Color.ORANGE);
		btnCross.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		Operations.add(btnCross);
		
		btnDevide = new JButton("/");
		btnDevide.addActionListener(new EventHandlerKeypad());
		btnDevide.setBackground(Color.ORANGE);
		btnDevide.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		Operations.add(btnDevide);
		
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new EventHandlerKeypad());
		btnPlus.setBackground(Color.ORANGE);
		btnPlus.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		Operations.add(btnPlus);
		
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new EventHandlerKeypad());
		btnMinus.setBackground(Color.ORANGE);
		btnMinus.setFont(new Font("±¼¸²", Font.PLAIN, 25));
		Operations.add(btnMinus);
	}
    class EventHandlerFeature implements ActionListener {
    	 
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(Text.getCaretPosition()<0) 
        		return;
        	JButton btn = (JButton) e.getSource();
        	StringBuffer tempString = new StringBuffer(Text.getText());
        	int tempCaret = Text.getCaretPosition();
        	String tempStringBtn = btn.getText()+"(";
        	tempString.insert(tempCaret,tempStringBtn);
			Text.setText(tempString.toString());
			Text.setCaretPosition(tempCaret+tempStringBtn.length());
        }
 
    }
    class EventHandlerKeypad implements ActionListener {
   	 
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(Text.getCaretPosition()<0) 
        		return;
        	JButton btn = (JButton) e.getSource();
        	StringBuffer tempString = new StringBuffer(Text.getText());
        	int tempCaret = Text.getCaretPosition();
        	String tempStringBtn = btn.getText();
        	tempString.insert(tempCaret,btn.getText());
			Text.setText(tempString.toString());
			Text.setCaretPosition(tempCaret+tempStringBtn.length());
        }
 
    }
    class EventHandlerRemove implements ActionListener {
      	 
        @Override
        public void actionPerformed(ActionEvent e) {
        	if(Text.getCaretPosition()<=0) 
        		return;
        	StringBuffer tempString = new StringBuffer(Text.getText());
        	int tempCaret = Text.getCaretPosition()-1;
			tempString.deleteCharAt(tempCaret);
			Text.setText(tempString.toString());
			Text.setCaretPosition(tempCaret);
        }
 
    }
    class EventHandlerEnter implements ActionListener {
     	 
        @Override
        public void actionPerformed(ActionEvent e) {
        	String text = Text.getText();
        	if(text.length()<=0) 
        		return;
        	
        	postfix.InfixToPostfix postfix = new postfix.InfixToPostfix();
        	
        	List<String> textPitches = new ArrayList<>(Arrays.asList((postfix.convToExpression(text)).split(" ")));
        	Stack<Double> doubleStack = new Stack<Double>();
        	
        	for(String temp : textPitches)
        	{
        		if(Calculation.arithmetic.isArithmetic(temp.charAt(0)))
        		{
        			doubleStack.push(Calculation.arithmetic.arithmeticCal(
        					doubleStack.pop(), doubleStack.pop() , temp.charAt(0)));
        			continue;
        		}
    			doubleStack.push(Double.parseDouble(temp));
        	}
        	Text.setText(doubleStack.get(0).toString());
        }
 
    }
}
