package database;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	
public class tableDAO {


		private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
		private static final String USER = "js06m13";
		private static final String PASS = "mcjoojh0562!";
		ArrayList<tableDTO> members = new ArrayList<tableDTO>();
		
		public tableDAO() {
			this.getList();
		}
		public Connection getConn() {
			
			Connection con = null;
			
			try {
				Class.forName(DRIVER);

				con = DriverManager.getConnection(URL,USER,PASS);
				System.out.print("Table DB Connect Success\n");
				
			}catch(ClassNotFoundException e) {
				System.out.print("Table Driver load fail\n");
			}catch(SQLException e) {
				System.out.print("Table Connect fail\n");
				System.out.print(e);
			}
			return con;
		}
		
		public void Table(tableDTO dto) {
			
			Connection con = null;
			String sql = "insert into rtable (res_code7, alone, two, four, many) values (?,?,?,?,?)";
			PreparedStatement ps = null;
		
			try {
				con = getConn();
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, dto.getcode7());
				ps.setInt(2, dto.getalone());
				ps.setInt(3, dto.gettwo());
				ps.setInt(4, dto.getfour());
				ps.setInt(5, dto.getmany());
				ps.executeUpdate();
				
				}catch(SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("tableDAO.table : " + e.getMessage());
				}
			finally {
				try {
					if(ps != null) ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
		
		public ArrayList<tableDTO> getList(){
			Connection con = null;
			Statement ps = null;
			ResultSet rs = null;

			try {
				con = getConn();
				String sql = "select * from rtable";
				ps = con.createStatement();
				rs = ps.executeQuery(sql);
				
				while(rs.next()) {
					tableDTO dto = new tableDTO();
					dto.setcode7(rs.getInt("res_code7"));
					dto.setalone(rs.getInt("alone"));
					dto.settwo(rs.getInt("two"));
					dto.setfour(rs.getInt("four"));
					dto.setmany(rs.getInt("many"));
					members.add(dto);
				}
				return members;
			}catch(SQLException e) {
				e.printStackTrace();	
			}finally {
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(con != null) con.close(); 
					
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}		
			}
			return null;
		}
		
		
		public boolean update(tableDTO dto){
			Connection con = null;
			String sql = "update rtable set res_code7=?,alone=?, two=?, four=?, many=?";
			PreparedStatement ps = null;
			ResultSet rs = null;
		
	
				
			boolean b = false;
			try {
				con = getConn();
				ps = con.prepareStatement(sql);
				ps.setInt(1, dto.getcode7());
				ps.setInt(2, dto.getalone());
				ps.setInt(3, dto.gettwo());
				ps.setInt(4, dto.getfour());
				ps.setInt(5, dto.getmany());
				
				if(ps.executeUpdate()>0)
					b=true;

			} catch (Exception e) {

				System.out.println("modifyData err : " + e);

			} finally {

				try {

					if(rs!=null)rs.close();

					if(ps!=null)ps.close();

					if(con !=null)con.close();

				} catch (Exception e2) {

					// TODO: handle exception

				}
			}

			return b;

		}

}
