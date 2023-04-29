package jdbc;
import java.sql.*;
public class PSDemo {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
			PreparedStatement pstmt = con.prepareStatement("select marks from student where rollno = ?");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				System.out.println(rs.getInt(1));
			}
			/*
			PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?)");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2,args[1]);
			pstmt.setInt(3,Integer.parseInt(args[2]));
			pstmt.executeUpdate();
			System.out.println("One Record Inserted Successfully");
			*/
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
