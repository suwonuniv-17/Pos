package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class payDAO {
	
   private static final String DRIVER = "com.mysql.jdbc.Driver";
   private static final String URL = "jdbc:mysql://js06m13.cafe24.com/js06m13";
   private static final String USER = "js06m13";
   private static final String PASS = "mcjoojh0562!";
   
   //DB 뿰寃  硫붿냼 뱶
   public Connection getConn() {
      
      Connection con = null;
      
      try {
         Class.forName(DRIVER);

         con = DriverManager.getConnection(URL,USER,PASS);
         System.out.print("DB Connect Success");
         
      }catch(ClassNotFoundException e) {
         System.out.print("Driver load fail");
      }catch(SQLException e) {
         System.out.print("Connect fail");
         System.out.print(e);
      }
      return con;
   }
   
   
   //저장된 메뉴 로드
   public ArrayList<payDTO> loadMenu() {
	   Connection con=null;
	   ResultSet rs=null;
	   PreparedStatement pstmt = null;
	   ArrayList<payDTO> list = new ArrayList<payDTO>();
	   try {
	       con = getConn();
	       String sql = "SELECT menuname, menuprice  FROM menu WHERE res_code2 = ? ORDER BY menuname ASC";
	       pstmt = con.prepareStatement(sql);
	       String code =User.getRes_code();
	       pstmt.setString(1, code);
	       rs = pstmt.executeQuery();
	       
	       while(rs.next()) {
	    	   payDTO dto = new payDTO();
	           dto.setMenuname(rs.getString("menuname"));
	           dto.setMenuprice(rs.getString("menuprice"));
	           list.add(dto);
	        }
	       
	     } catch (Exception e) {
	         System.out.println("예외발생:deleteMember()=> "+e.getMessage());
	     }finally {
	         try {
	             if(rs != null) rs.close();
	             if(pstmt != null) pstmt.close();
	             if(con != null) con.close(); 
	             
	          }catch(SQLException e) {
	             System.out.println(e.getMessage());
	          }      
	       }   
	     return list;
   }
}
