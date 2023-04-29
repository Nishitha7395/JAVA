package jdbc;
import java.sql.*;
public class InsertDemo {

	public static void main(String[] args) {
		try{
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into student values(1, 'Venkatesh', 88)");
			System.out.println("One Record Inserted Successfully");
			}catch(Exception e){
				System.err.println(e);
			}


	}

}
