package GUI;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;


public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final String names[] = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "0", ".", "=", "/"};
	private JPanel padPanel = new JPanel(new GridLayout(4, 4));
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 458, 38);
		textField.setFont(new Font("굴림", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(textField);
		
		JButton buttons[] = new JButton[names.length]; // 키패드 배열 생성  
		for(int count = 0; count < names.length; count++)
		{
		 buttons[count] = new JButton(names[count]);
		 padPanel.add(buttons[count]);
		}
		add(padPanel, BorderLayout.CENTER);
	}

}
