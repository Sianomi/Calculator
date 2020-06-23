package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class History extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			History dialog = new History();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
			btnGetHistory.setFont(new Font("±¼¸²", Font.PLAIN, 25));
			btnGetHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			contentPanel.add(btnGetHistory);
		}
		{
			JButton btnRemoveHistory = new JButton("\uAE30\uB85D\uC0AD\uC81C");
			btnRemoveHistory.setForeground(Color.WHITE);
			btnRemoveHistory.setBackground(new Color(0, 0, 51));
			btnRemoveHistory.setFont(new Font("±¼¸²", Font.PLAIN, 25));
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
}
