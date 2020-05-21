import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class settingPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public settingPanel() {
		setBounds(0,0,640,497);
		setLayout(null);

		
		JLabel lblSetting = new JLabel("\uD14C\uC774\uBE14 Setting");
		lblSetting.setBounds(249, 37, 135, 27);
		lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetting.setForeground(Color.ORANGE);
		lblSetting.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		add(lblSetting);
		
		JLabel numtabelLabel_8 = new JLabel("\uB2E8\uCCB4\uC11D(8\uC778 \uC774\uC0C1) :");
		numtabelLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_8.setForeground(Color.BLACK);
		numtabelLabel_8.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		numtabelLabel_8.setBounds(56, 128, 131, 22);
		add(numtabelLabel_8);
		
		JLabel numtabelLabel_4 = new JLabel("4\uC778 Tabel\t         :");
		numtabelLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_4.setForeground(Color.BLACK);
		numtabelLabel_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		numtabelLabel_4.setBounds(56, 210, 129, 22);
		add(numtabelLabel_4);
		
		JLabel numtabelLabel_2 = new JLabel("2\uC778 Tabel\t         :");
		numtabelLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_2.setForeground(Color.BLACK);
		numtabelLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		numtabelLabel_2.setBounds(56, 300, 129, 22);
		add(numtabelLabel_2);
		
		JLabel numtabelLabel_1 = new JLabel("1\uC778 Tabel\t         :");
		numtabelLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_1.setForeground(Color.BLACK);
		numtabelLabel_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		numtabelLabel_1.setBounds(56, 394, 129, 22);
		add(numtabelLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textPane.setBounds(213, 128, 75, 28);
		add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textPane_1.setBounds(213, 210, 75, 28);
		add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textPane_2.setBounds(213, 300, 75, 28);
		add(textPane_2);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		textPane_3.setBounds(213, 394, 75, 28);
		add(textPane_3);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tablePanel.setBounds(362, 128, 233, 294);
		add(tablePanel);
		
		JLabel tabelLabel = new JLabel("\uBC30\uCE58\uB3C4\r\n");
		tabelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tabelLabel.setForeground(Color.BLACK);
		tabelLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		tabelLabel.setBounds(455, 93, 42, 20);
		add(tabelLabel);
	}
}
