import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.payDAO;
import database.payDTO;

import javax.swing.JTextField;

public class FramePay extends JFrame {
	private Image img_logo = new ImageIcon(FrameMain.class.getResource("reso/logo.png")).getImage()
			.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	private Image img_pack = new ImageIcon(FrameMain.class.getResource("reso/package.png")).getImage()
			.getScaledInstance(23, 33, Image.SCALE_SMOOTH);
	private Image img_wait = new ImageIcon(FrameMain.class.getResource("reso/waiting_line.png")).getImage()
			.getScaledInstance(23, 30, Image.SCALE_SMOOTH);

	private JTable payListTable;
	private JTextField togetTextField;
	JPanel menuPanel_;
	JPanel tablePanel;

	private MainProcess mainprocess;
	payDTO paydto;
	payDAO paydao;
	Framewait f_wait;
	FramePack f_pack;
	menuPanel menuP;

	int table_num;
	int menu_num;
	JButton[] mbtn;
	JButton[] mbtn_menu;
	JButton tableButton;

	String[] str_menu;
	String[] menuCount;
	String tablebuttonIndex;
	String menuName;

	int i = 0;
	int rownum;
	Vector<String> userColumn;
	DefaultTableModel model;
	Object recode[] = new Object[3];
	JPanel payPanel = new JPanel();
	ActionListener tableListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			model.setNumRows(0);
			System.out.println(e);
			System.out.print("\n" + e.getSource() + "\n");

			tableButton = (JButton) e.getSource();
			tablebuttonIndex = tableButton.getText().split("\\(")[0];
			loadTabel();
			
		}
	};
	
	
	ActionListener menuListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int count = 1;
			JButton menuButton = (JButton) e.getSource();

			menuName = menuButton.getText().split("[0-9]")[0];
			paydto.setTablenum(Integer.parseInt(tablebuttonIndex));
			paydto.setMenucode(menuName);
			paydto.setMenucount(count);
			paydao.insertMenu(paydto);
			
			loadTabel();
		}

	};

	public FramePay() {

		menuP = new menuPanel();
		paydto = new payDTO();
		paydao = new payDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1080, 700);
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
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?",
						"Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					FramePay.this.dispose();
					paydao.deleteDB();
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
		closeLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
		panel.add(closeLabel);

		// 뜝 룞 삕 뜝 룞 삕 뜝 룞 삕 듉
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
		packLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
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
		waitLabel.setFont(new Font("한컴 고딕", Font.BOLD, 24));
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
		lblNewLabel.setFont(new Font("한컴 고딕 ", Font.BOLD, 20));
		lblNewLabel.setBounds(38, 0, 218, 31);
		panel.add(lblNewLabel);

		tablePanel = new JPanel();
		tablePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablePanel.setBounds(10, 43, 480, 640);
		tablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		contentPane.add(tablePanel);
		this.inputTable();

		// menuPanel 뜝 룞 삕 menuTable.rowCount() 뜝 룞 삕 뜝 룞 삕 뜝 룞 삕 뜝 룞 삕 Button 뜝 룞 삕 뜝 룞
		// 삕.

		menuPanel_ = new JPanel();
		menuPanel_.setBorder(new LineBorder(new Color(0, 0, 0)));
		menuPanel_.setBounds(508, 43, 560, 342);
		contentPane.add(menuPanel_);
		menuPanel_.setLayout(new GridLayout(5, 4));
		this.menuButton();

		
		payPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		payPanel.setBounds(506, 395, 560, 295);
		contentPane.add(payPanel);
		payPanel.setLayout(null);
		
		
		// Jtable 추가
		userColumn = new Vector<String>();
		userColumn.addElement("메뉴");
		userColumn.addElement("수량");
		userColumn.addElement("가격");
		model = new DefaultTableModel(userColumn, 0);
		
		
		payListTable = new JTable(model);
		payListTable.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, },
				new String[] { "\uBA54\uB274", "\uC218\uB7C9", "\uAC00\uACA9" }));
		payListTable.getColumnModel().getColumn(0).setPreferredWidth(92);
		payListTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		payListTable.getColumnModel().getColumn(2).setPreferredWidth(86);
		payListTable.setBounds(12, 42, 294, 243);
		payPanel.add(payListTable);
		
		

		JLabel lblNewLabel_1_1 = new JLabel("\uC218\uB7C9");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("한컴 고딕 ", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(125, 10, 60, 22);
		payPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(219, 10, 60, 22);
		payPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_1.setBounds(37, 10, 60, 22);
		payPanel.add(lblNewLabel_1);

		JLabel newLabel_1 = new JLabel("\uCD1D \uAE08 \uC561 :");
		newLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		newLabel_1.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		newLabel_1.setBounds(318, 33, 93, 22);
		payPanel.add(newLabel_1);

		JLabel newLabel_2 = new JLabel("\uBC1B\uC740\uAE08\uC561 :");
		newLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		newLabel_2.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		newLabel_2.setBounds(318, 83, 93, 22);
		payPanel.add(newLabel_2);

		JLabel newtLabel = new JLabel("\uBC1B\uC744\uAE08\uC561 :");
		newtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newtLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		newtLabel.setBounds(318, 131, 93, 22);
		payPanel.add(newtLabel);

		JLabel lblNewLabel_1_3_4 = new JLabel("\uAC70\uC2A4\uB984\uB3C8 :");
		lblNewLabel_1_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3_4.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		lblNewLabel_1_3_4.setBounds(321, 175, 93, 22);
		payPanel.add(lblNewLabel_1_3_4);

		togetTextField = new JTextField();
		togetTextField.setBounds(423, 89, 96, 21);
		payPanel.add(togetTextField);
		togetTextField.setColumns(10);

		JLabel totalcostLabel = new JLabel("0");
		totalcostLabel.setHorizontalAlignment(SwingConstants.LEFT);
		totalcostLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		totalcostLabel.setBounds(423, 33, 93, 22);
		payPanel.add(totalcostLabel);

		JLabel togetLabel = new JLabel("0");
		togetLabel.setHorizontalAlignment(SwingConstants.LEFT);
		togetLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		togetLabel.setBounds(423, 131, 93, 22);
		payPanel.add(togetLabel);

		JLabel changeLabel = new JLabel("0");
		changeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		changeLabel.setFont(new Font("한컴 고딕", Font.BOLD, 20));
		changeLabel.setBounds(426, 175, 93, 22);
		payPanel.add(changeLabel);

		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setFont(new Font("한컴 고딕", Font.BOLD, 24));
		btnNewButton.setBounds(348, 228, 183, 57);
		payPanel.add(btnNewButton);

		setVisible(true);
	}

	public void setMain(MainProcess mainprocess) {
		this.mainprocess = mainprocess;
	}

	public void menuButton() {
		ArrayList<payDTO> menulist = new ArrayList<payDTO>();
		menulist = paydao.getMenu();
		menu_num = menulist.size();
		str_menu = new String[menu_num];
		mbtn_menu = new JButton[menu_num];

		for (int i = 0; i < menu_num; i++) {
			str_menu[i] = menulist.get(i).getMenuname() + "     " + menulist.get(i).getMenuprice();
			mbtn_menu[i] = new JButton(str_menu[i]);
			mbtn_menu[i].setFont(new Font("한컴 고딕", Font.BOLD, 10));
			mbtn_menu[i].addActionListener(menuListener);
			menuPanel_.add(mbtn_menu[i]);
		}
	}

	public void inputTable() {
		ArrayList<payDTO> tablelist = new ArrayList<payDTO>();
		tablelist = paydao.getTable();

		table_num = tablelist.get(0).getalone() + tablelist.get(0).gettwo() + tablelist.get(0).getfour()
				+ tablelist.get(0).getmany();
		mbtn = new JButton[table_num];
		String[] str = new String[table_num];
		LineBorder b2 = new LineBorder(Color.black);
		if (table_num > 16) {
			for (int i = 0; i < table_num; i++) {
				if (i < tablelist.get(0).getalone()) {
					str[i] = Integer.toString(i + 1) + "(1인석)";
					b2 = new LineBorder(new Color(178, 34, 34));
				} else if (i < tablelist.get(0).getalone() + tablelist.get(0).gettwo()) {
					str[i] = Integer.toString(i + 1) + "(\n" + "2인석)";
					b2 = new LineBorder(new Color(255, 215, 0));
				} else if (i < tablelist.get(0).getalone() + tablelist.get(0).gettwo() + tablelist.get(0).getfour()) {
					str[i] = Integer.toString(i + 1) + "(\n" + "4인석)";
					b2 = new LineBorder(new Color(0, 0, 205));
				} else if (i < table_num) {
					str[i] = Integer.toString(i + 1) + "(\n" + "다인석)";
					b2 = new LineBorder(new Color(0, 100, 0));
				}
				int row = table_num / 5;

				if (table_num % 5 != 0) {
					row++;
				}
				int b = (int) 640 / (row) - (30 * 2);

				mbtn[i] = new JButton(str[i]);
				mbtn[i].setPreferredSize(new Dimension(70, b));
				mbtn[i].setBorder(b2);
				mbtn[i].setBackground(new Color(240, 240, 240));
				mbtn[i].setFont(new Font("한컴 고딕", Font.BOLD, 10));
				mbtn[i].addActionListener(tableListener);
				tablePanel.add(mbtn[i]);
			}

		}

		else {
			for (int i = 0; i < table_num; i++) {
				if (i < tablelist.get(0).getalone()) {
					str[i] = Integer.toString(i + 1) + "(1인석)";
					b2 = new LineBorder(new Color(178, 34, 34));
				} else if (i < tablelist.get(0).getalone() + tablelist.get(0).gettwo()) {
					str[i] = Integer.toString(i + 1) + "(\n" + "2인석)";
					b2 = new LineBorder(new Color(255, 215, 0));
				} else if (i < tablelist.get(0).getalone() + tablelist.get(0).gettwo() + tablelist.get(0).getfour()) {
					str[i] = Integer.toString(i + 1) + "(\n" + "4인석)";
					b2 = new LineBorder(new Color(0, 0, 205));
				} else if (i < table_num) {
					str[i] = Integer.toString(i + 1) + "(\n" + "다인석)";
					b2 = new LineBorder(new Color(0, 100, 0));
				}

				mbtn[i] = new JButton(str[i]);
				mbtn[i].setPreferredSize(new Dimension(70, 75));
				mbtn[i].setBorder(b2);
				mbtn[i].setBackground(new Color(240, 240, 240));
				mbtn[i].setFont(new Font("한컴 고딕", Font.BOLD, 10));
				mbtn[i].addActionListener(tableListener);
				tablePanel.add(mbtn[i]);
			}
		}
	}

	
	
	public void loadTabel() {
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		paydto.setTablenum(Integer.parseInt(tablebuttonIndex));
		list = paydao.loadMenu(paydto);

		for (rownum = 0; rownum < list.size(); rownum++) {
			recode[0] = list.get(rownum).getMenuname();
			recode[1] = list.get(rownum).getMenucount();
			recode[2] = list.get(rownum).getMenuprice();
			model.addRow(recode);
		}
		
		list.clear();
		
	}
	
	

}