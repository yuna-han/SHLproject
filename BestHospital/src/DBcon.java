import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public final class DBcon {
	private static Connection conn = null;
	private static Statement stmt = null;
	public static ResultSet rs = null;
	
	public static void dbopen() { //db연결
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공");
		}
		catch (Exception ex) {
			System.out.println("드라이버 검색 실패 error: " + ex);
			return;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/shl?useUnicode=yes&characterEncoding=UTF8","root","apmsetup");
			System.out.println("DB 연결 성공");
		}
		catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
	}
	
	
	public static void query(String sql) { //db 쿼리
		try {
			stmt = conn.createStatement();
			System.out.println(sql);
			if(stmt.execute(sql)) {
				rs = stmt.getResultSet();
				System.out.println("쿼리 성공");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("쿼리 실패");
		}
	}

}

