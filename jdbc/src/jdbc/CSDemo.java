package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CSDemo {

	public static void main(String[] args) {
	try {
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
			//PreparedStatement pstmt = con.prepareStatement("select marks from student where rollno = ?");
			CallableStatement cstmt=con.prepareCall("{call insertpro(?,?,?)}");
			cstmt.setInt(1,Integer.parseInt(args[0]));
			cstmt.setString(2,args[1]);
			cstmt.setInt(3, Integer.parseInt(args[2]));
			cstmt.execute();
			System.out.println("One Record Inserted Successfully");
			
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
