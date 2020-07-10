import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Framewait extends JFrame {

	private JPanel contentPane;
	private JTable table;

	
	public Framewait() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 500, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblKnockKnockWait = new JLabel("Knock Knock WAIT");
		lblKnockKnockWait.setForeground(Color.WHITE);
		lblKnockKnockWait.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblKnockKnockWait.setBounds(12, 0, 218, 31);
		panel.add(lblKnockKnockWait);
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Framewait.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				closeLabel.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				closeLabel.setForeground(Color.black);
			}
		});
		closeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		closeLabel.setForeground(Color.BLACK);
		closeLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		closeLabel.setBounds(470, -3, 16, 33);
		panel.add(closeLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\uB300\uAE30\uBC88\uD638", "\uC778\uC6D0\uC218", "\uC190\uB2D8\uBA85"},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uB300\uAE30\uBC88\uD638", "\uC778\uC6D0\uC218", "\uC190\uB2D8\uBA85"
			}
		));
		table.setBounds(12, 48, 474, 545);
		contentPane.add(table);
		
		JButton delButton = new JButton("\uB300\uAE30 \uC644\uB8CC");
		delButton.setFont(new Font("±¼¸²", Font.BOLD, 25));
		delButton.setBounds(33, 628, 433, 42);
		contentPane.add(delButton);
		
		setVisible(true);
	}
}
