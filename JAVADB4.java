package projectDB3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JAVADB4 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("숫자로만 입력하세요:");
		String pid = in.nextLine();
		int id = Integer.parseInt(pid);
		System.out.println("프로젝트 이름을 입력하세요:");
		String pname = in.nextLine();
		System.out.println("프로젝트 기간을 입력하세요(숫자로만):");
		String pday = in.nextLine();
		int day = Integer.parseInt(pday);
		System.out.println("프로젝트 내용을 입력하세요.");
		String pcontent = in.nextLine();
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String dbURL = "jdbc:mariadb://127.0.0.1:3306/projectshow";
		String dbID = "user";
		String dbPassword = "123456";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			String SQL = "INSERT INTO projecttable (id,projectname,projectday,projectcontent)" + "VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			pstmt.setString(2, pname);
			pstmt.setInt(3, day);
			pstmt.setString(4, pcontent);
			
			int result = pstmt.executeUpdate();
			System.out.println("결과는: "+result);
			
			String SQLR = "SELECT * FROM projecttable";
			pstmt = conn.prepareStatement(SQLR);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("프로젝트관련 내용 출력");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getString(4));
				System.out.println();
				
			}
			pstmt.close();
			conn,close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
