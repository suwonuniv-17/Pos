import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;

public class FramePay extends JFrame {
	private Image img_logo = new ImageIcon(FrameMain.class.getResource("reso/logo.png")).getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH);
	private Image img_pack = new ImageIcon(FrameMain.class.getResource("reso/package.png")).getImage().getScaledInstance(23,33, Image.SCALE_SMOOTH);
	private Image img_wait = new ImageIcon(FrameMain.class.getResource("reso/waiting_line.png")).getImage().getScaledInstance(23,30, Image.SCALE_SMOOTH);
	
	menuPanel menuP;
	private JTable payListTable;
	private JTextField togetTextField;

	Framewait f_wait;
	FramePack f_pack;
	
	private MainProcess mainprocess;
	
	public FramePay() {
		
		menuP = new menuPanel();
		
		
		
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
		closeLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 24));
		panel.add(closeLabel);
		
		
		
		//�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�듉
		JLabel packLabel = new JLabel("");
		packLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				mainprocess.showFramePack();
			}
		});
		packLabel.setHorizontalAlignment(SwingConstants.CENTER);
		packLabel.setForeground(Color.BLACK);
		packLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 24));
		packLabel.setBounds(1017, 0, 33, 33);
		packLabel.setIcon(new ImageIcon(img_pack));
		panel.add(packLabel);
		
		JLabel waitLabel = new JLabel("");
		waitLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainprocess.showFramewait();
			}
		});
		waitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		waitLabel.setForeground(Color.BLACK);
		waitLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 24));
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
		lblNewLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		lblNewLabel.setBounds(38, 0, 218, 31);
		panel.add(lblNewLabel);
		
		JPanel layoutPanel = new JPanel();
		layoutPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		layoutPanel.setBounds(10, 43, 484, 647);
		contentPane.add(layoutPanel);
		
		
		//menuPanel�뜝�룞�삕 menuTable.rowCount()�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 Button �뜝�룞�삕�뜝�룞�삕.  

		JPanel menuPanel_ = new JPanel();
		menuPanel_.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel_.setBounds(508, 43, 560, 342);
		contentPane.add(menuPanel_);
		menuPanel_.setLayout(new GridLayout(5, 4));
		
		String [] str = new String[20];
		JButton [] mbtn= new JButton[20];

		for(int i =0 ; i < 20 ; i++) {
			//str DB menu�뜝�룞�삕�뜝�룞�삕
			//str[i] = (String) menuP.menuTable.getValueAt(i, 0);
			mbtn[i] = new JButton(str[i]);
			menuPanel_.add(mbtn[i]);
		}
		
		JPanel payPanel = new JPanel();
		payPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		payPanel.setBounds(506, 395, 560, 295);
		contentPane.add(payPanel);
		payPanel.setLayout(null);
		
		payListTable = new JTable();
		payListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uBA54\uB274", "\uC218\uB7C9", "\uAC00\uACA9"
			}
		));
		payListTable.getColumnModel().getColumn(0).setPreferredWidth(92);
		payListTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		payListTable.getColumnModel().getColumn(2).setPreferredWidth(86);
		payListTable.setBounds(12, 42, 294, 243);
		payPanel.add(payListTable);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(125, 10, 60, 22);
		payPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(219, 10, 60, 22);
		payPanel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 10, 60, 22);
		payPanel.add(lblNewLabel_1);
		
		JLabel newLabel_1 = new JLabel("\uCD1D \uAE08 \uC561 :");
		newLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel_1.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		newLabel_1.setBounds(318, 33, 93, 22);
		payPanel.add(newLabel_1);
		
		JLabel newLabel_2 = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		newLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		newLabel_2.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		newLabel_2.setBounds(318, 83, 93, 22);
		payPanel.add(newLabel_2);
		
		JLabel newtLabel = new JLabel("\uBC1B\uC744\uAE08\uC561 :");
		newtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newtLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		newtLabel.setBounds(318, 131, 93, 22);
		payPanel.add(newtLabel);
		
		JLabel lblNewLabel_1_3_4 = new JLabel("\uAC70\uC2A4\uB984\uB3C8 :");
		lblNewLabel_1_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_4.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		lblNewLabel_1_3_4.setBounds(321, 175, 93, 22);
		payPanel.add(lblNewLabel_1_3_4);
		
		togetTextField = new JTextField();
		togetTextField.setBounds(423, 89, 96, 21);
		payPanel.add(togetTextField);
		togetTextField.setColumns(10);
		
		JLabel totalcostLabel = new JLabel("0");
		totalcostLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalcostLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		totalcostLabel.setBounds(423, 33, 93, 22);
		payPanel.add(totalcostLabel);
		
		JLabel togetLabel = new JLabel("0");
		togetLabel.setHorizontalAlignment(SwingConstants.LEFT);
		togetLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		togetLabel.setBounds(423, 131, 93, 22);
		payPanel.add(togetLabel);
		
		JLabel changeLabel = new JLabel("0");
		changeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		changeLabel.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 20));
		changeLabel.setBounds(426, 175, 93, 22);
		payPanel.add(changeLabel);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setFont(new Font("�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�", Font.BOLD, 24));
		btnNewButton.setBounds(348, 228, 183, 57);
		payPanel.add(btnNewButton);
		
		setVisible(true);
	}
	
	public void setMain(MainProcess mainprocess) {
		this.mainprocess = mainprocess;
	}
}
