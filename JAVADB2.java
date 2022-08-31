package projectDB3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class JAVADB2 {

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
			String SQL = "SELECT bookid AS id, bookname as bname, publisher AS pub , price AS money "
					+" FROM Book "
					+"WHERE price < 20000 ";
			pstmt = conn.prepareStatement(SQL);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("bname"));
				System.out.println(rs.getString("pub"));
				System.out.println(rs.getInt("money"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
