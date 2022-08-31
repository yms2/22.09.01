package projectDB3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class JAVADB6 {

	public static void main(String[] args) {

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String dbURL="jdbc:mariadb://localhost:3306/projectshow";
		String dbID = "user";
		String dbPassword="123456";
		
		try {
			String SQL = "SELECT SUM(projectday) FROM projecttable";
			pstmt = conn.prepareStatement(SQL); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
