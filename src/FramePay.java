import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class FramePay extends JFrame {
	private Image img_logo = new ImageIcon(FrameMain.class.getResource("reso/·Î°í.png")).getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
	private Image img_pack = new ImageIcon(FrameMain.class.getResource("reso/package.png")).getImage().getScaledInstance(23,33, Image.SCALE_SMOOTH);
	private Image img_wait = new ImageIcon(FrameMain.class.getResource("reso/waiting_line.png")).getImage().getScaledInstance(23,30, Image.SCALE_SMOOTH);
	
	
	public FramePay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 700);
		setUndecorated(true);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 1080, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel closeLabel = new JLabel("X");
		closeLabel.setBounds(1052, 0, 16, 33);
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FramePay.this.dispose();
				}
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
		panel.add(closeLabel);
		
		
		
		//Æ÷Àå ¹öÆ°
		JLabel packLabel = new JLabel("");
		packLabel.setHorizontalAlignment(SwingConstants.CENTER);
		packLabel.setForeground(Color.BLACK);
		packLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		packLabel.setBounds(1017, 0, 33, 33);
		packLabel.setIcon(new ImageIcon(img_pack));
		panel.add(packLabel);
		
		JLabel waitLabel = new JLabel("");
		waitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		waitLabel.setForeground(Color.BLACK);
		waitLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 24));
		waitLabel.setBounds(986, 0, 33, 33);
		waitLabel.setIcon(new ImageIcon(img_wait));
		panel.add(waitLabel);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setBounds(0, 0, 33, 33);
		logoLabel.setIcon(new ImageIcon(img_logo));
		panel.add(logoLabel);
		
		JLabel lblNewLabel = new JLabel("Knock Knock Pos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lblNewLabel.setBounds(38, 0, 218, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 43, 484, 647);
		contentPane.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(508, 43, 560, 342);
		contentPane.add(panel_1_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(508, 395, 560, 295);
		contentPane.add(panel_1_1_1);
		
		
		
		setVisible(true);
	}
}
