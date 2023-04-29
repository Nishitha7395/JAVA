package jdbc;
import java.sql.*;
public class CreateDemo {

	public static void main(String[] args) {
		try{
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","manager");
			System.out.println("Connection Established Successfully");
			Statement stmt = con.createStatement();
			stmt.execute("create table student(rollno number(3),name varchar2(10),marks number(3))");
			System.out.println("Table created successfully");
			}catch(Exception e){
				System.err.println(e);
			}

	}

}
