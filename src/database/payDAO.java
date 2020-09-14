package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class payDAO {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
	private static final String USER = "js06m13";
	private static final String PASS = "mcjoojh0562!";
	int count=1;
	// DB 연결
	public Connection getConn() {

		Connection con = null;

		try {
			Class.forName(DRIVER);

			con = DriverManager.getConnection(URL, USER, PASS);
			System.out.print("DB Connect Success");

		} catch (ClassNotFoundException e) {
			System.out.print("Driver load fail");
		} catch (SQLException e) {
			System.out.print("Connect fail");
			System.out.print(e);
		}
		return con;
	}

	// 저장된 메뉴 로드
	public ArrayList<payDTO> getMenu() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		try {
			con = getConn();
			String sql = "SELECT menuname, menuprice  FROM menu WHERE res_code2 = ? ORDER BY menuname ASC";
			pstmt = con.prepareStatement(sql);
			String code = User.getRes_code();
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setMenuname(rs.getString("menuname"));
				dto.setMenuprice(rs.getString("menuprice"));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("예외발생:deleteMember()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}

	
	//table 로드
	public ArrayList<payDTO> getTable() {
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			con = getConn();
			String sql = "SELECT alone, two, four, many  FROM rtable WHERE res_code7 = ?";
			pstmt = con.prepareStatement(sql);
			String code = User.getRes_code();
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setalone(Integer.parseInt(rs.getString("alone")));
				dto.settwo(Integer.parseInt(rs.getString("two")));
				dto.setfour(Integer.parseInt(rs.getString("four")));
				dto.setmany(Integer.parseInt(rs.getString("many")));
				list.add(dto);
			}

		} catch (Exception e) {
			System.out.println("예외발생:deleteMember()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}

	// table별 메뉴 삽입
	public void insertMenu(payDTO dto) {
		Connection con = null;
		String sql = "INSERT INTO tablemenu (tablenum,menucount,menu_code2) VALUES (?,?,(SELECT menu_code FROM menu WHERE menuname = ? ))";
		PreparedStatement ps = null;

		int res_code2 = Integer.parseInt(User.getRes_code());

		try {
			con = getConn();
			ps = con.prepareStatement(sql);

			ps.setInt(1, dto.getTablenum());
			ps.setInt(2, dto.getMenucount());
			ps.setString(3, dto.getMenucode());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("menuDAO.insetMenu : " + e.getMessage());
		}

		finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//table별 저장된 메뉴 로드
	public ArrayList<payDTO> loadMenu(payDTO d) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		ArrayList<payDTO> list = new ArrayList<payDTO>();
		
		try {
			con = getConn();
			String sql = "SELECT menuprice, menuname FROM menu WHERE menu_code IN (select menu_code2 from tablemenu where tablenum=?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,Integer.toString(d.getTablenum()));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setMenuname(rs.getString("menuname"));
				dto.setMenuprice(rs.getString("menuprice"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("예외발생:loadMenu()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}
	
	/*
	public int menuCount(payDTO d) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConn();
			String sql = "SELECT * from tablemenu where menu_code2 = (SELECT menu_code FROM menu WHERE menuname = ?) and tablenum =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,d.getMenucode());
			pstmt.setString(2, Integer.toString(d.getTablenum()));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pstmt.setString(1, d.getMenuname());
				pstmt.setString(2, Integer.toString(count));
				pstmt.setString(3, d.getMenucode());
				
				pstmt.executeUpdate();
				count++;
			}
			else {
				insertMenu(d);
			}
		} catch(Exception e) {
			
		}finally {
			
		}
		return count;
	}
	
	//menucount 
	public int menu_count(payDTO d) {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int count=1;
		String a= null;
		String b = null;
		
		try {
			con = getConn();
			String sql = "SELECT menu_code2, COUNT(*) as menunum FROM tablemenu WHERE tablenum = ? GROUP BY tablenum HAVING menu_code2 = (SELECT menu_code FROM menu WHERE menuname = ?)";
			pstmt = con.prepareStatement(sql);
			a =Integer.toString(d.getTablenum());
			b= d.getMenucode();
			pstmt.setString(1,Integer.toString(d.getTablenum()));
			pstmt.setString(2,d.getMenucode());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				payDTO dto = new payDTO();
				dto.setMenucount(Integer.parseInt(rs.getString("menunum")));			
				count= dto.getMenucount();
			}
		} catch (Exception e) {
			System.out.println("예외발생:menu_count()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return count;
	}
	*/
	
	//DB 내용 삭제
	public void deleteDB() {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConn();
			String sql = "TRUNCATE tablemenu";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("예외발생:menu_count()=> " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
}