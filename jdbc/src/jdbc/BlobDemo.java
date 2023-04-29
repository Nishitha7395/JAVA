package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BlobDemo {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement pstmt = con.prepareStatement("insert into images values(?,?)");
			pstmt.setString(1, args[0]);
			FileInputStream fs=new FileInputStream(args[1]);
			pstmt.setBinaryStream(2, fs, fs.available());
			pstmt.executeUpdate();
			System.out.println("One Image Inserted Successfully");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
