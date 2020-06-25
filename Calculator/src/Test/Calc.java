package Test;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class Calc extends JFrame implements ActionListener {
 
    // Frame 및 컴포넌트 변수 선언.
    private JFrame frm;
    private JPanel buttons;
    private JPanel texts_p;
 
    private JButton[] button = new JButton[30];
    // private TextArea text;
    private JTextField text1;
    private JTextField text2;
 
    // 피연산자와 연산자를 담을 변수
    private String first_num = "";
    private String second_num = "";
    private String op_num = "";
    private String num = "";
 
    // 계산기 첫째줄 텍스트필드 내 연산식을 표현하기 위해 연산식을 누적하는 변수
    private String op_str = "";
 
    // 계산된 결과를 담을 변수
    private double result = 0;
 
    // 음수 / 양수 버튼이 클릭되었는지 확인하기 위한 변수 (Default = false)
    private boolean chk_pm = false;
 
    // 계산기 버튼에 해당하는 값을 배열에 설정
    private String[] arr = { "MC", "MR", "MS", "M+", "M-", "←", "CE", "C", "±",
            "√", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2",
            "3", "-", ".", "0", "00", "+", "=", "," };
 
    // 프레임 내 컴포넌트 배치를 위한 초기화 메서드
    public void init() {
        buttons = new JPanel();
        texts_p = new JPanel();
        texts_p.setLayout(new BorderLayout());
        texts_p.setPreferredSize(new Dimension(280, 60));
        // text = new TextArea("0\n2", 2, 18, TextArea.SCROLLBARS_NONE);
 
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension(240, 30));
        text1.setBorder(null);
        text1.setEnabled(false);
//        text1.setEditable(false);
        text1.setHorizontalAlignment(JTextField.RIGHT);
 
        text2 = new JTextField("0");
        text2.setPreferredSize(new Dimension(240, 30));
        text2.setBorder(null);
        text2.setFont(new Font("GulimChe", Font.PLAIN, 20));
        text2.setEnabled(false);
//        text2.setEditable(false);
        text2.setHorizontalAlignment(JTextField.RIGHT);
 
        buttons.setLayout(new GridLayout(6, 5, 4, 4));
        for (int i = 0; i < 30; i++) {
            button[i] = new JButton(arr[i]);
            button[i].addActionListener(this);
            buttons.add(button[i]);
        }
        texts_p.add("North", text1);
        texts_p.add("South", text2);
        frm.add("North", texts_p);
        frm.add("South", buttons);
    }
 
    public Calc() {
        frm = new JFrame();
        frm.setTitle("계산기");
        frm.setBounds(500, 300, 300, 300);
        frm.setLayout(new BorderLayout());
        // frm.setResizable(false);
        init();
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public static void main(String[] args) {
        new Calc();
    }
 
    // 숫자로 치환한 문자열 (실제 문자열이지만 111+11 식으로 값을 전달 받은 후 자바스크립트를 통해 실제 연산 처리)을
    // 연산 처리 후 int 값으로 반환한다.
    public static double operate(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine scr = mgr.getEngineByName("JavaScript");
        double op_num = (Double) scr.eval(input);
        return op_num;
 
    }
 
    // Button Action 처리 메서드
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
 
        JButton jbt = (JButton) e.getSource();
        
        /*
         * 사칙연산('=' 부호를 포함)을 제외한 나머지 특수 기호를 입력한 경우의 이벤트 처리
         */
        
        // 현재 입력받고 있는 값만 초기화 
        // 이전에 첫번째 피연산자 값이 있으면 그대로 대기
        if(jbt.getText().equals("CE")) {
            num = "";
            text2.setText("0");
        } 
        
        // 모든 값을 초기화
        else if (jbt.getText().equals("C")) {
            num = "";
            first_num = "";
            second_num = "";
            result = 0;
            op_num = "";
            op_str = "";
            text2.setText("0");
        } 
        
        // 현재 입력 받고 있는 num 값에 대한 √ 값을 처리
        else if (jbt.getText().equals("√")) {
            op_str += "sqrt(" + num + ")";
            text1.setText(op_str);
            double num_do = Double.parseDouble(num);
            
            // 첫번째 피연산자에 입력된 값이 없는 경우
            if(num.length() != 0 && first_num.length() == 0) {
                num = Math.sqrt(num_do) + "";
                text2.setText(num);
                if(first_num.length() == 0) {
                    first_num = num;
                }
                num = "";
            } else if (num.length() != 0 && first_num.length() != 0 && second_num.length() == 0) {
                num = Math.sqrt(num_do) + "";
                second_num = num;
                String full_str = first_num + op_num + second_num;
                System.out.println(full_str);
                try {
                    result = operate(full_str);
                    text2.setText(result + "");
                } catch (ScriptException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                first_num = result + "";
                second_num = "";    
                num = "";
            }            
            else if (num.equals("0") || num.equals("00")) {
                text2.setText(result + "");
            }
        }
    
        /*
         * 사칙연산('=' 부호를 포함) 및 숫자를 입력한 경우의 이벤트 처리
         */
 
        // 1. 프로그램이 실행된 후 처음으로 값이 입력되는 경우
        // 숫자를 클릭한 것인지 연산자를 클릭한 것인지 확인한다
        // (숫자일 경우 num 문자열 변수에 값을 계속 저장한 후 연산자를
        // 만나는 순간 피연산자를 저장하는
        // 변수에 옮겨야 한다.)
 
        // num 변수의 길이가 0의 의미는
        // * 프로그램이 실행된 이후 현재까지 아무런 입력이 없었다는 뜻
        // * 혹은 앞서 연산자(=를 제외한 연산자)를 입력받아 연산자 후의 피연산자 값을 입력 받는 경우이다.
        if (num.length() == 0) {
 
            // Swing에서는 getText()함수를 이용하여 버튼에 저장되어 있는 값을 가져온다.
            // AWT에서는 getLabel() 함수를 이용하면 됨.
            if (jbt.getText().equals("+") || jbt.getText().equals("-")
                    || jbt.getText().equals("*") || jbt.getText().equals("/")) {
                // 입력 받은 피연산자 값이 현재 없는 경우이면서
                // 첫번째 피연산자가 이미 입력되어진 경우 (first_num)
                // first_num 값을 0으로 초기화 하고 op_num에 현재 입력 받은 연산자를 넣어준다.
                if (first_num.length() == 0) {
                    first_num = "0";
                    op_num = jbt.getText();
                    op_str = first_num + op_num;
                    text1.setText(op_str);
                }
                // 앞서 첫번째 피연산자가 입력되어 있는 경우에는
                // 연산기호만 계속 바꿔준다.
                // ex> 11+ >>> - 입력 시 11- ....
                else if (first_num.length() != 0) {
                    op_num = jbt.getText();
                    op_str = first_num + op_num;
                    text1.setText(op_str);
                }
            } else if (jbt.getText().equals("1") || jbt.getText().equals("2")
                    || jbt.getText().equals("3") || jbt.getText().equals("4")
                    || jbt.getText().equals("5") || jbt.getText().equals("6")
                    || jbt.getText().equals("7") || jbt.getText().equals("8")
                    || jbt.getText().equals("9")) {
 
                // 앞서 특정 연산이 처리되어 '=' 부호를 만난 후
                // 연산기호가 아닌 숫자가 입력되는 경우에는 
                // 모든 값을 초기화하여 처음부터 실행되는 것과 동일하게 처리해야 한다.
                if(op_num.equals("=")) {
                    result = 0;
                    op_str = "";
                    first_num = "";
                    num = "";
                    second_num = "";
                    op_num = "";
                }
                // 연산기호가 아닌 숫자가 입력되었을 경우
                // 숫자 값을 num 변수에 누적한다.
                num += jbt.getText();
                text2.setText(num);
            } else if (jbt.getText().equals("0") || jbt.getText().equals("00")) {
                
                // 앞서 특정 연산이 처리되어 '=' 부호를 만난 후
                // 연산기호가 아닌 숫자가 입력되는 경우에는 
                // 모든 값을 초기화하여 처음부터 실행되는 것과 동일하게 처리해야 한다.
                if(op_num.equals("=")) {
                    result = 0;
                    op_str = "";
                    first_num = "";
                    num = "";
                    second_num = "";
                    op_num = "";
                }
                result = 0;
                text2.setText(jbt.getText());
            }
        }
 
        // 2. 변수에 처음으로 값을 입력 받은 후 계속적으로 값을 입력 받는 경우를 처리
        // num 변수에 첫번째로 값이 입력된 이후에 처리 과정.
        else if (num.length() != 0) {
            // 연산자를 만난 경우
            if (jbt.getText().equals("+") || jbt.getText().equals("-")
                    || jbt.getText().equals("*") || jbt.getText().equals("/")) {
                // 연산자를 만나기 전까지 num에 저장한 값을 첫번째 혹은 두번째 피연산자에 기록한다.
 
                if (first_num.length() == 0) {
                    first_num = num;
                } else if (second_num.length() == 0) {
                    second_num = num;
                    
                    // 첫번째 피연산자와 두번째 피연산자 모두 값이 입력된 경우
                    // '=' 를 만나지 않았더라하더도 연산을 진행한 후
                    // 연산된 값을 result 변수에 담는다.
                    // 그 후, result 값을 first 변수에 저장하고, =를 만나기 전 다시 입력하는 수에 대해서는 second 값에
                    // 저장하여 계속 연산을 진행.
                    
                    // 두번째 피연산자 값까지 모두 입력이 된 경우
                    // 연산한 결과를 first_num 값에 저장하고
                    // 출력하여 보여준다.
                    if (first_num.length() != 0 && second_num.length() != 0) {
                        String full_str = first_num + op_num + second_num;
                        try {
                            result = operate(full_str);
                            first_num = result + "";
                            second_num = "";
                            text2.setText(result + "");
                        } catch (ScriptException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                    }
                }
                
                // op_num에 현재 입력 받은 연산자를 넣어준다.
                op_num = jbt.getText();
                op_str += num + op_num;
                num = "";
                text1.setText(op_str);
                
            } else if ((jbt.getText().equals("0") || jbt.getText().equals("1") || jbt.getText().equals("2")
                    || jbt.getText().equals("3") || jbt.getText().equals("4")
                    || jbt.getText().equals("5") || jbt.getText().equals("6")
                    || jbt.getText().equals("7") || jbt.getText().equals("8") || jbt
                    .getText().equals("9")) || jbt.getText().equals("00")) {
                // 연산기호가 아닌 숫자가 입력되었을 경우
                // 숫자 값을 num 변수에 누적한다.
                num += jbt.getText();
                text2.setText(num);
            }
        }
 
        // 3. '=' 부호를 입력 받은 경우
        if (jbt.getText().equals("=")) {
 
            // result 값이 0이면 0을 그대로 화면에 출력
            if (result == 0 && first_num.length() == 0) {
                text2.setText(result + "");
            } 
            // 첫번째 피연산자 값만 입력 받은 후 '=' 부호를 만나는 경우
            // 저장되어 있는 첫번째 피연산자 값만 그대로 출력해주면 된다.
            else if (result == 0 && first_num.length() != 0
                    && num.length() == 0) {
                text2.setText(first_num);
            } 
            // 두번째 피연산자까지 입력한 뒤에 '=' 부호를 만나는 경우
            // 연산 처리 후 결과를 출력해주면 된다.
            else if (first_num.length() != 0
                    && second_num.length() == 0 && num.length() != 0) {
                second_num = num;
                String full_str = first_num + op_num + second_num;
                try {
                    result = operate(full_str);
                    text2.setText(result + "");
                } catch (ScriptException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            // '=' 를 만나기 전 연산된 값이 있으면서, 뒤 피연산자 값이 더이상 없는 경우
            // 현재까지 계산된 값(result) 를 출력한다.
            else if (result != 0 && second_num.length() == 0) {
                text2.setText(result + "");
            } else if (result != 0 && second_num.length() != 0) {
                String full_str = first_num + op_num + second_num;
                try {
                    result = operate(full_str);
                    text2.setText(result + "");
                } catch (ScriptException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }            
 
            // '=' 부호를 만난경우 
            // 첫번째 줄에는 클리어
            // 연산식을 표시하는 op_str에는 연산된 값을 저장한다.
            // 첫번째 피연산자에도 현재 연산결과(result)를 저장한다.
            // 새로운 입력을 받기 위해 num 값을 초기화한다.
            // 새로운 입력을 두번째 피연산자에 넣기 위해 미리 두번째 피연산자 변수를 초기화 한다.
            text1.setText("");
            op_str = result + "";
            first_num = result + "";
            num = "";
            second_num = "";            
            op_num = "=";
        }
    }
}