import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.ComponentOrientation;



public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	protected JTextComponent lblMessage;
	private JLabel lblloginMessage = new JLabel(" ");
	
	private MainProcess main;
	private FrameMain f_main;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {
		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setInheritsPopupMenu(true);
		contentPane.setBorder(new LineBorder(new Color(255, 165, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(180, 154, 250, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtUserName.getText().equals("Username")) {
					txtUserName.setText("");
				}
				else {
					txtUserName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtUserName.getText().equals(""))
					txtUserName.setText("Username");
			}
		});
		txtUserName.setBorder(null);
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUserName.setText("Username");
		txtUserName.setBounds(14, 10, 170, 20);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(180, 206, 250, 40);
		contentPane.add(panel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtPassword.getText().equals("Password")) {
					txtPassword.setEchoChar('¡Ü');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtPassword.getText().equals("")) {
					txtPassword.setText("Password");
					txtPassword.setEchoChar((char)0);
				}
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setText("Password");
		txtPassword.setBounds(14, 10, 170, 20);
		panel_1.add(txtPassword);
		
		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(txtUserName.getText().equals("admin") && txtPassword.getText().equals("admin123")) {
					lblloginMessage.setText("");
					JOptionPane.showMessageDialog(null, "Login Successful!");
					main.showFrameMain();
					
				}
				else if(txtUserName.getText().equals("") || txtUserName.getText().equals("Username") ||
						txtPassword.getText().equals("") || txtPassword.getText().equals("Password")) {
					lblloginMessage.setText("Please input all requirements!");
				}
				else
					lblloginMessage.setText("Username and password didn't match!");
			}
		});
		pnlBtnLogin.setBorder(null);
		pnlBtnLogin.setForeground(Color.WHITE);
		pnlBtnLogin.setBackground(new Color(255, 165, 0));
		pnlBtnLogin.setBounds(180, 289, 250, 50);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.BOLD, 15));
		lblLogin.setBounds(100, 12, 62, 26);
		pnlBtnLogin.add(lblLogin);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"CLOSE?", "confirmation", JOptionPane.YES_NO_OPTION)==0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Arial", Font.BOLD, 15));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(580, 0, 20, 20);
		contentPane.add(lblX);
		
		JLabel logolabel = new JLabel("KNOCK");
		logolabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		logolabel.setForeground(new Color(255, 69, 0));
		logolabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		logolabel.setBounds(219, 59, 157, 63);
		contentPane.add(logolabel);
		
		JLabel logolabel2 = new JLabel("KNOCK");
		logolabel2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		logolabel2.setForeground(Color.RED);
		logolabel2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		logolabel2.setBounds(278, 77, 157, 63);
		contentPane.add(logolabel2);
		lblloginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblloginMessage.setForeground(Color.RED);
		lblloginMessage.setFont(new Font("Arial", Font.PLAIN, 15));
		lblloginMessage.setBounds(150, 258, 305, 20);
		contentPane.add(lblloginMessage);
		setLocationRelativeTo(null);
		
		
		setVisible(true);
	}
	
	public void setMain(MainProcess main) {
		this.main = main;
	}
	

}
