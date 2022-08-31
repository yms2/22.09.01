package projectDB3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class projectDB1 {

	public static void main(String[] args) {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String dbURL="jdbc:mariadb://localhost:3306/user";
		String dbID = "user";
		String dbPassword="123456";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "SELECT distinct publisher AS pub FROM Book";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString(1)+rs.getString("pub"));
				System.out.println();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
