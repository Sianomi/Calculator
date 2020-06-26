package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.SystemColor;

public class History extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public History() {
		getContentPane().setBackground(Color.BLACK);
		setTitle("\uAE30\uB85D\uAD00\uB9AC");
		setBounds(100, 100, 388, 333);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));
		{
			JButton btnGetHistory = new JButton("\uAE30\uB85D\uC870\uD68C");
			btnGetHistory.setForeground(Color.WHITE);
			btnGetHistory.setBackground(new Color(0, 0, 51));
			btnGetHistory.setFont(new Font("굴림", Font.PLAIN, 25));
			btnGetHistory.addActionListener(new EventHandlerRemove());
			contentPanel.add(btnGetHistory);
		}
		{
			JButton btnRemoveHistory = new JButton("\uAE30\uB85D\uC0AD\uC81C");
			btnRemoveHistory.addActionListener(new EventHandlerRemove());
			btnRemoveHistory.setForeground(Color.WHITE);
			btnRemoveHistory.setBackground(new Color(0, 0, 51));
			btnRemoveHistory.setFont(new Font("굴림", Font.PLAIN, 25));
			contentPanel.add(btnRemoveHistory);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.ORANGE);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	class EventHandlerRemove implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			 UIManager um=new UIManager();
			 um.put("OptionPane.background",Color.BLACK);
			 um.put("Panel.background",Color.BLACK);
			 um.put("OptionPane.messageForeground", Color.WHITE);
			 um.put("Panel.messageForeground", Color.WHITE);
			 um.put("Button.background", Color.ORANGE);
			 
			 String []yesNo = {"예", "아니오"};
			 int check = JOptionPane.showOptionDialog(null, "기록을 모두 삭제하시겠습니까?", "기록삭제확인", 
					 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ,null,yesNo,yesNo[0]);
			 
			 if(check==0)
			 {
				 JOptionPane.showMessageDialog(null, "삭제했습니다.", "완료알림", JOptionPane.CLOSED_OPTION);
			 }
		}
		
	}
}
