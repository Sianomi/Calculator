package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.SystemColor;
import History.History;

public class HistoryGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public HistoryGUI() {
		UIManager.put("OptionPane.background",Color.BLACK);
		UIManager.put("Panel.background",Color.BLACK);
		UIManager.put("OptionPane.messageForeground", Color.WHITE);
		UIManager.put("Panel.messageForeground", Color.WHITE);
		UIManager.put("Button.background", Color.ORANGE);
		
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
			btnGetHistory.addActionListener(new EventHandlerGetList());
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
	
	class EventHandlerGetList implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			History file = new History();
			JDialog view = new JDialog();
			String[] str = null;
			try {
				str = file.Read().toArray(new String[0]);
			} catch (IOException e1) {
				System.out.println(e1);
				return;
			}
			JList<String> listView = new JList<String>(str);
			view.getContentPane().add(new JScrollPane(listView),"Center");
			listView.setBackground(Color.BLACK);
			listView.setForeground(Color.WHITE);
			view.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			view.setTitle("기록목록");
			view.setSize(400,300);
			view.setVisible(true);
		}
	}
	
	class EventHandlerRemove implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			 String []yesNo = {"예", "아니오"};
			 History file = new History();
			 int check = JOptionPane.showOptionDialog(null, "기록을 모두 삭제하시겠습니까?", "기록삭제확인", 
					 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE ,null,yesNo,yesNo[0]);
			 
			 if(check==0)
			 {
				try {
					file.Reset();
				} catch (IOException e1) {
					System.out.println(e1);
					return;
				}
				JOptionPane.showMessageDialog(null, "삭제했습니다.", "완료알림", JOptionPane.CLOSED_OPTION);
			 }
		}
		
	}
}
