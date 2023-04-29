package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select rollno, name, marks from student");
			//ResultSet rs=stmt.executeQuery("select * from student");
			rs.absolute(1);
			System.out.print(rs.getInt("rollno")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.println(rs.getInt("marks"));
			rs.deleteRow();
			System.out.println("One record deleted successfully");
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}

	}

}
