import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class mypagePanel extends JPanel {

	
	private Image img_profile = new ImageIcon(FrameMain.class.getResource("reso/profile.png")).getImage().getScaledInstance(112,132, Image.SCALE_SMOOTH);
	/**
	 * Create the panel.
	 */
	public mypagePanel() {
		setBounds(0,0,640,497);
		setLayout(null);

		
		JLabel idLabel = new JLabel("ID :");
		idLabel.setHorizontalAlignment(SwingConstants.LEFT);
		idLabel.setForeground(Color.BLACK);
		idLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		idLabel.setBounds(136, 24, 25, 22);
		add(idLabel);
		
		JLabel nameLabel = new JLabel("\uC131\uD568 :");
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		nameLabel.setBounds(136, 75, 42, 22);
		add(nameLabel);
		
		JLabel infoLabel = new JLabel("\uAC00\uAC8C \uC815\uBCF4 :");
		infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		infoLabel.setBounds(136, 134, 80, 22);
		add(infoLabel);
		
		JLabel profilLabel = new JLabel("");
		profilLabel.setForeground(new Color(0, 0, 0));
		profilLabel.setBounds(12, 24, 112, 132);
		profilLabel.setIcon(new ImageIcon(img_profile));
		add(profilLabel);
		
		JButton btnNewButton = new JButton("more");
		btnNewButton.setBounds(518, 137, 80, 23);
		add(btnNewButton);
		
		JLabel lblPw_1_1 = new JLabel("\uB9E4\uCD9C\uD604\uD669");
		lblPw_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPw_1_1.setForeground(Color.BLACK);
		lblPw_1_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		lblPw_1_1.setBounds(12, 189, 64, 22);
		add(lblPw_1_1);
		
		JPanel payPanel = new JPanel();
		payPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		payPanel.setBounds(12, 234, 616, 253);
		add(payPanel);
	}
}
