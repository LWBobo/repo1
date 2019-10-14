import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Demo2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pichuli","root","123456789");
		//	String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)";
			String sql = "select * from t_user where id>?";
			conn.setAutoCommit(false);
			st = conn.createStatement();
//			st.execute("delete  from user where id>0"); //删除操作
			/** 批处理操作  */
			for (int i = 0; i < 50; i++) {
				sql = "insert into user (username,pwd,regTime) values ('liu" + i + "',123456,now())";
				st.addBatch(sql);
			}
			st.executeBatch();
			conn.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//				rs.close();
				st.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
