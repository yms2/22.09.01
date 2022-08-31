package projectDB3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.DriverManager;

public class JAVADB5 {

	public static void main(String[] args) {
		
		System.out.println("검색할 프로젝트 명을 입력하세요");
		Scanner in = new Scanner(System.in);
		String searchText = in.nextLine();

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String dbURL="jdbc:mariadb://localhost:3306/projectshow";
		String dbID = "user";
		String dbPassword="123456";
		String SQL ="SELECT * FROM projecttable WHERE projectname LIKE ?";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, searchText);
			rs = pstmt.executeQuery();
			
			System.out.println("검색한 결과");
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
