package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {

	public static void main(String[] args) {
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","system");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=stmt.executeQuery("select rollno, name, marks from student");
			//ResultSet rs=stmt.executeQuery("select * from student");
			rs.absolute(5);
			System.out.print(rs.getInt("rollno")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.println(rs.getInt("marks"));
			rs.updateInt(3,77);
			rs.updateRow();
			System.out.println("One record updated successfully");
			System.out.print(rs.getInt("rollno")+"\t");
			System.out.print(rs.getString("name")+"\t");
			System.out.println(rs.getInt("marks"));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		

	}

}
