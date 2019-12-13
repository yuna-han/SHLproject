import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public final class DBcon {
	private static Connection conn = null;
	private static Statement stmt = null;
	public static ResultSet rs = null;
	
	public static void dbopen() { //db����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("����̹� �˻� ����");
		}
		catch (Exception ex) {
			System.out.println("����̹� �˻� ���� error: " + ex);
			return;
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/shl?useUnicode=yes&characterEncoding=UTF8","root","apmsetup");
			System.out.println("DB ���� ����");
		}
		catch (Exception e) {
			System.out.println("DB ���� ����");
		}
	}
	
	
	public static void query(String sql) { //db ����
		try {
			stmt = conn.createStatement();
			System.out.println(sql);
			if(stmt.execute(sql)) {
				rs = stmt.getResultSet();
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("���� ����");
		}
	}

}

