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
 
    // Frame �� ������Ʈ ���� ����.
    private JFrame frm;
    private JPanel buttons;
    private JPanel texts_p;
 
    private JButton[] button = new JButton[30];
    // private TextArea text;
    private JTextField text1;
    private JTextField text2;
 
    // �ǿ����ڿ� �����ڸ� ���� ����
    private String first_num = "";
    private String second_num = "";
    private String op_num = "";
    private String num = "";
 
    // ���� ù°�� �ؽ�Ʈ�ʵ� �� ������� ǥ���ϱ� ���� ������� �����ϴ� ����
    private String op_str = "";
 
    // ���� ����� ���� ����
    private double result = 0;
 
    // ���� / ��� ��ư�� Ŭ���Ǿ����� Ȯ���ϱ� ���� ���� (Default = false)
    private boolean chk_pm = false;
 
    // ���� ��ư�� �ش��ϴ� ���� �迭�� ����
    private String[] arr = { "MC", "MR", "MS", "M+", "M-", "��", "CE", "C", "��",
            "��", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x", "1", "2",
            "3", "-", ".", "0", "00", "+", "=", "," };
 
    // ������ �� ������Ʈ ��ġ�� ���� �ʱ�ȭ �޼���
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
        frm.setTitle("����");
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
 
    // ���ڷ� ġȯ�� ���ڿ� (���� ���ڿ������� 111+11 ������ ���� ���� ���� �� �ڹٽ�ũ��Ʈ�� ���� ���� ���� ó��)��
    // ���� ó�� �� int ������ ��ȯ�Ѵ�.
    public static double operate(String input) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine scr = mgr.getEngineByName("JavaScript");
        double op_num = (Double) scr.eval(input);
        return op_num;
 
    }
 
    // Button Action ó�� �޼���
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
 
        JButton jbt = (JButton) e.getSource();
        
        /*
         * ��Ģ����('=' ��ȣ�� ����)�� ������ ������ Ư�� ��ȣ�� �Է��� ����� �̺�Ʈ ó��
         */
        
        // ���� �Է¹ް� �ִ� ���� �ʱ�ȭ 
        // ������ ù��° �ǿ����� ���� ������ �״�� ���
        if(jbt.getText().equals("CE")) {
            num = "";
            text2.setText("0");
        } 
        
        // ��� ���� �ʱ�ȭ
        else if (jbt.getText().equals("C")) {
            num = "";
            first_num = "";
            second_num = "";
            result = 0;
            op_num = "";
            op_str = "";
            text2.setText("0");
        } 
        
        // ���� �Է� �ް� �ִ� num ���� ���� �� ���� ó��
        else if (jbt.getText().equals("��")) {
            op_str += "sqrt(" + num + ")";
            text1.setText(op_str);
            double num_do = Double.parseDouble(num);
            
            // ù��° �ǿ����ڿ� �Էµ� ���� ���� ���
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
         * ��Ģ����('=' ��ȣ�� ����) �� ���ڸ� �Է��� ����� �̺�Ʈ ó��
         */
 
        // 1. ���α׷��� ����� �� ó������ ���� �ԷµǴ� ���
        // ���ڸ� Ŭ���� ������ �����ڸ� Ŭ���� ������ Ȯ���Ѵ�
        // (������ ��� num ���ڿ� ������ ���� ��� ������ �� �����ڸ�
        // ������ ���� �ǿ����ڸ� �����ϴ�
        // ������ �Űܾ� �Ѵ�.)
 
        // num ������ ���̰� 0�� �ǹ̴�
        // * ���α׷��� ����� ���� ������� �ƹ��� �Է��� �����ٴ� ��
        // * Ȥ�� �ռ� ������(=�� ������ ������)�� �Է¹޾� ������ ���� �ǿ����� ���� �Է� �޴� ����̴�.
        if (num.length() == 0) {
 
            // Swing������ getText()�Լ��� �̿��Ͽ� ��ư�� ����Ǿ� �ִ� ���� �����´�.
            // AWT������ getLabel() �Լ��� �̿��ϸ� ��.
            if (jbt.getText().equals("+") || jbt.getText().equals("-")
                    || jbt.getText().equals("*") || jbt.getText().equals("/")) {
                // �Է� ���� �ǿ����� ���� ���� ���� ����̸鼭
                // ù��° �ǿ����ڰ� �̹� �ԷµǾ��� ��� (first_num)
                // first_num ���� 0���� �ʱ�ȭ �ϰ� op_num�� ���� �Է� ���� �����ڸ� �־��ش�.
                if (first_num.length() == 0) {
                    first_num = "0";
                    op_num = jbt.getText();
                    op_str = first_num + op_num;
                    text1.setText(op_str);
                }
                // �ռ� ù��° �ǿ����ڰ� �ԷµǾ� �ִ� ��쿡��
                // �����ȣ�� ��� �ٲ��ش�.
                // ex> 11+ >>> - �Է� �� 11- ....
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
 
                // �ռ� Ư�� ������ ó���Ǿ� '=' ��ȣ�� ���� ��
                // �����ȣ�� �ƴ� ���ڰ� �ԷµǴ� ��쿡�� 
                // ��� ���� �ʱ�ȭ�Ͽ� ó������ ����Ǵ� �Ͱ� �����ϰ� ó���ؾ� �Ѵ�.
                if(op_num.equals("=")) {
                    result = 0;
                    op_str = "";
                    first_num = "";
                    num = "";
                    second_num = "";
                    op_num = "";
                }
                // �����ȣ�� �ƴ� ���ڰ� �ԷµǾ��� ���
                // ���� ���� num ������ �����Ѵ�.
                num += jbt.getText();
                text2.setText(num);
            } else if (jbt.getText().equals("0") || jbt.getText().equals("00")) {
                
                // �ռ� Ư�� ������ ó���Ǿ� '=' ��ȣ�� ���� ��
                // �����ȣ�� �ƴ� ���ڰ� �ԷµǴ� ��쿡�� 
                // ��� ���� �ʱ�ȭ�Ͽ� ó������ ����Ǵ� �Ͱ� �����ϰ� ó���ؾ� �Ѵ�.
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
 
        // 2. ������ ó������ ���� �Է� ���� �� ��������� ���� �Է� �޴� ��츦 ó��
        // num ������ ù��°�� ���� �Էµ� ���Ŀ� ó�� ����.
        else if (num.length() != 0) {
            // �����ڸ� ���� ���
            if (jbt.getText().equals("+") || jbt.getText().equals("-")
                    || jbt.getText().equals("*") || jbt.getText().equals("/")) {
                // �����ڸ� ������ ������ num�� ������ ���� ù��° Ȥ�� �ι�° �ǿ����ڿ� ����Ѵ�.
 
                if (first_num.length() == 0) {
                    first_num = num;
                } else if (second_num.length() == 0) {
                    second_num = num;
                    
                    // ù��° �ǿ����ڿ� �ι�° �ǿ����� ��� ���� �Էµ� ���
                    // '=' �� ������ �ʾҴ����ϴ��� ������ ������ ��
                    // ����� ���� result ������ ��´�.
                    // �� ��, result ���� first ������ �����ϰ�, =�� ������ �� �ٽ� �Է��ϴ� ���� ���ؼ��� second ����
                    // �����Ͽ� ��� ������ ����.
                    
                    // �ι�° �ǿ����� ������ ��� �Է��� �� ���
                    // ������ ����� first_num ���� �����ϰ�
                    // ����Ͽ� �����ش�.
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
                
                // op_num�� ���� �Է� ���� �����ڸ� �־��ش�.
                op_num = jbt.getText();
                op_str += num + op_num;
                num = "";
                text1.setText(op_str);
                
            } else if ((jbt.getText().equals("0") || jbt.getText().equals("1") || jbt.getText().equals("2")
                    || jbt.getText().equals("3") || jbt.getText().equals("4")
                    || jbt.getText().equals("5") || jbt.getText().equals("6")
                    || jbt.getText().equals("7") || jbt.getText().equals("8") || jbt
                    .getText().equals("9")) || jbt.getText().equals("00")) {
                // �����ȣ�� �ƴ� ���ڰ� �ԷµǾ��� ���
                // ���� ���� num ������ �����Ѵ�.
                num += jbt.getText();
                text2.setText(num);
            }
        }
 
        // 3. '=' ��ȣ�� �Է� ���� ���
        if (jbt.getText().equals("=")) {
 
            // result ���� 0�̸� 0�� �״�� ȭ�鿡 ���
            if (result == 0 && first_num.length() == 0) {
                text2.setText(result + "");
            } 
            // ù��° �ǿ����� ���� �Է� ���� �� '=' ��ȣ�� ������ ���
            // ����Ǿ� �ִ� ù��° �ǿ����� ���� �״�� ������ָ� �ȴ�.
            else if (result == 0 && first_num.length() != 0
                    && num.length() == 0) {
                text2.setText(first_num);
            } 
            // �ι�° �ǿ����ڱ��� �Է��� �ڿ� '=' ��ȣ�� ������ ���
            // ���� ó�� �� ����� ������ָ� �ȴ�.
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
            // '=' �� ������ �� ����� ���� �����鼭, �� �ǿ����� ���� ���̻� ���� ���
            // ������� ���� ��(result) �� ����Ѵ�.
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
 
            // '=' ��ȣ�� ������� 
            // ù��° �ٿ��� Ŭ����
            // ������� ǥ���ϴ� op_str���� ����� ���� �����Ѵ�.
            // ù��° �ǿ����ڿ��� ���� ������(result)�� �����Ѵ�.
            // ���ο� �Է��� �ޱ� ���� num ���� �ʱ�ȭ�Ѵ�.
            // ���ο� �Է��� �ι�° �ǿ����ڿ� �ֱ� ���� �̸� �ι�° �ǿ����� ������ �ʱ�ȭ �Ѵ�.
            text1.setText("");
            op_str = result + "";
            first_num = result + "";
            num = "";
            second_num = "";            
            op_num = "=";
        }
    }
}