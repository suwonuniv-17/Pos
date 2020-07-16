import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import database.tableDTO;
import database.tableDAO;

public class test extends JPanel {

	private JTextPane textPane;
	private JTextPane textPane_1;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JPanel tablePanel;
	tableDAO tabledao;
	tableDTO tabledto;
	int alone;
	int two;
	int four;
	int many;
	
	public test() {
		setBounds(0,0,640,497);
		setLayout(null);

		tabledao = new tableDAO();
		tabledto = new tableDTO();
		
		JLabel lblSetting = new JLabel("\uD14C\uC774\uBE14 Setting");
		lblSetting.setBounds(249, 37, 144, 27);
		lblSetting.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetting.setForeground(Color.ORANGE);
		lblSetting.setFont(new Font("���� ���", Font.BOLD, 20));
		add(lblSetting);
		
		JLabel numtabelLabel_8 = new JLabel("\uB2E8\uCCB4\uC11D(8\uC778 \uC774\uC0C1) :");
		numtabelLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_8.setBackground(Color.green);
		numtabelLabel_8.setForeground(Color.BLACK);
		numtabelLabel_8.setFont(new Font("���� ���", Font.PLAIN, 16));
		numtabelLabel_8.setBounds(56, 128, 131, 22);
		add(numtabelLabel_8);
		
		JLabel numtabelLabel_4 = new JLabel("4인 Table\t          :");
		numtabelLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_4.setBackground(Color.blue);
		numtabelLabel_4.setForeground(Color.BLACK);
		numtabelLabel_4.setFont(new Font("���� ���", Font.PLAIN, 16));
		numtabelLabel_4.setBounds(56, 210, 129, 22);
		add(numtabelLabel_4);
		
		JLabel numtabelLabel_2 = new JLabel("2인 Table\t         :");
		numtabelLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_2.setBackground(Color.yellow);
		numtabelLabel_2.setForeground(Color.BLACK);
		numtabelLabel_2.setFont(new Font("���� ���", Font.PLAIN, 16));
		numtabelLabel_2.setBounds(56, 300, 129, 22);
		add(numtabelLabel_2);
		
		JLabel numtabelLabel_1 = new JLabel("1인 Table\t         :");
		numtabelLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		numtabelLabel_1.setBackground(Color.red);
		numtabelLabel_1.setForeground(Color.BLACK);
		numtabelLabel_1.setFont(new Font("���� ���", Font.PLAIN, 16));
		numtabelLabel_1.setBounds(56, 394, 129, 22);
		add(numtabelLabel_1);
		
		//many
		textPane = new JTextPane();
		textPane.setFont(new Font("���� ���", Font.PLAIN, 16));
		textPane.setBounds(213, 128, 75, 28);
		add(textPane);
		//four
		textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("���� ���", Font.PLAIN, 16));
		textPane_1.setBounds(213, 210, 75, 28);
		add(textPane_1);
		//two
		textPane_2 = new JTextPane();
		textPane_2.setFont(new Font("���� ���", Font.PLAIN, 16));
		textPane_2.setBounds(213, 300, 75, 28);
		add(textPane_2);
		//alone
		textPane_3 = new JTextPane();
		textPane_3.setFont(new Font("���� ���", Font.PLAIN, 16));
		textPane_3.setBounds(213, 394, 75, 28);
		add(textPane_3);
		
		//배치도
		tablePanel = new JPanel();
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tablePanel.setBounds(362, 128, 233, 294);
		add(tablePanel);
		tablePanel.setLayout(new GridLayout(4,0));
		JLabel tabelLabel = new JLabel("\uBC30\uCE58\uB3C4\r\n");
		tabelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tabelLabel.setForeground(Color.BLACK);
		tabelLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		tabelLabel.setBounds(442, 96, 70, 20);
		add(tabelLabel);
		
		JButton tableButton = new JButton("테이블 생성");
		tableButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "테이블이 생성되었습니다.");
				contentSet();
				inputTable();
				contentClear();
			}
		});
		tableButton.setFont(new Font("Dialog", Font.BOLD, 16));
		tableButton.setBounds(56, 445, 232, 40);
		add(tableButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setForeground(Color.BLACK);
		panel.setBounds(17, 134, 27, 22);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(0, 0, 205));
		panel_1.setBounds(17, 210, 27, 22);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBackground(new Color(255, 215, 0));
		panel_2.setBounds(17, 300, 27, 22);
		add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.BLACK);
		panel_3.setBackground(new Color(178, 34, 34));
		panel_3.setBounds(17, 394, 27, 22);
		add(panel_3);
	}
	
	
	//
	public void inputTable() {
		int sum = many+four+two+alone;
		JButton [] tbtn  = new JButton[sum];


		for(int i =0 ; i < sum ; i++) {
			tbtn[i] = new JButton();
			tablePanel.add(tbtn[i]);
			
			if(i<many) {
				tbtn[i].setBackground(new Color(0,100,0));
			}
			else if(i<many+four) {
				tbtn[i].setBackground(new Color(0,0,205));
			}
			else if(i<many+four+two) {
				tbtn[i].setBackground(new Color(255,215,0));
			}
			else if(i<sum) {
				tbtn[i].setBackground(new Color(178,34,34));
			}
		}
	}
	
	
	
	
	public void contentSet() {

		
		if(textPane.getText().equals("")||textPane_1.getText().equals("")||textPane_2.getText().equals("")||textPane_3.getText().equals(""))
			JOptionPane.showMessageDialog(this, "공백 없이 입력해 주세요.");
		else {
			many=Integer.parseInt(textPane.getText());
			four=Integer.parseInt(textPane_1.getText());
			two=Integer.parseInt(textPane_2.getText());
			alone=Integer.parseInt(textPane_3.getText());
		}
		int res_code =0;
		tabledto.setcode7(res_code);
		tabledto.setmany(many);
		tabledto.setfour(four);
		tabledto.settwo(two);
		tabledto.setalone(alone);
		
		tabledao.Table(tabledto);	
		res_code++;
	}
	
	public void contentClear() {
		textPane.setText("");
		textPane_1.setText("");
		textPane_2.setText("");
		textPane_3.setText("");
	}
}