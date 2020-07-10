import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.menuDAO;
import database.menuDTO;

import javax.swing.JButton;
import javax.swing.JTable;

public class menuPanel extends JPanel {
	public JTextField nameText;
	public JTextField costText;
	public JTable menuTable;
	public int rownum;
	JScrollPane sc;
	
	Vector<String> userColumn;
	DefaultTableModel model;
	Vector<String> userRow;
	
	menuDAO menudao;
	menuDTO menudto;
	
	
	public menuPanel() {
		
		setBounds(0,0,640,497);
		setLayout(null);
		menudao = new menuDAO();
		menudto = new menuDTO();
		
		
		JLabel lblNewLabel = new JLabel("\uC774\uB984 :");
		lblNewLabel.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 16));
		lblNewLabel.setBounds(388, 58, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC00\uACA9 :");
		lblNewLabel_1.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(388, 115, 57, 15);
		add(lblNewLabel_1);
		
		nameText = new JTextField();
		nameText.setBounds(441, 58, 172, 21);
		add(nameText);
		nameText.setColumns(10);
		
		costText = new JTextField();
		costText.setColumns(10);
		costText.setBounds(441, 115, 172, 21);
		add(costText);
	
		//Jtable 추가
		userColumn = new Vector<String>();
		userColumn.addElement("占쌨댐옙占싱몌옙");
		userColumn.addElement("占쏙옙占쏙옙");
		model = new DefaultTableModel(userColumn,0);

		menuTable = new JTable(model);
		menuTable.setToolTipText("");
		menuTable.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 16));
		menuTable.setBounds(12, 22, 355, 465);
		add(menuTable);
		
		
		ArrayList<menuDTO> list = new ArrayList<menuDTO>();
		list = menudao.loadMenu();
		
		
		//占쌩곤옙 占쏙옙튼
		JButton addButton = new JButton("\uCD94\uAC00");
		addButton.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 20));
		addButton.setBounds(443, 283, 125, 67);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				addTabel(nameText.getText(), costText.getText());
				contentSet();
				contentClear();
				}
		});
		add(addButton);
		
		
		//占쏙옙占쏙옙 占쏙옙튼
		JButton deleteButton = new JButton("\uC0AD\uC81C");
		deleteButton.setFont(new Font("占쏙옙占쏙옙 占쏙옙占�", Font.PLAIN, 20));
		deleteButton.setBounds(443, 369, 125, 68);
		add(deleteButton);
		
	
	}
	
	
	//Table 占쏙옙 占쌩곤옙
	public void addTabel(String name, String cost) {
		userRow = new Vector<String>();
		userRow.addElement(name);
		userRow.addElement(cost);
		model.addRow(userRow);
	}
	
	
		
	public void contentSet() {
		String menuname =null;
		String menuprice =null;

		if(nameText.getText().equals("") || costText.getText().equals(""))
			JOptionPane.showMessageDialog(this, "硫붾돱 �씠由꾩쓣 �엯�젰�븯�떆�삤.");
		else {
			menuname = nameText.getText();
			menuprice = costText.getText();
		}
		
		menudto.setManuname(menuname);
		menudto.setMenuprice(menuprice);
		
		menudao.insertMenu(menudto);
	}
	
	public void contentClear() {
		nameText.setText("");
		costText.setText("");
	}
	
	
}

