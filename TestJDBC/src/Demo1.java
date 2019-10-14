import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import util.JDBCutil;


public class Demo1 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			int num = 66;
			conn = JDBCutil.getMysqlConn();
			String sql = "update stu set id="+ "654321"+" where id= "+"123456";
			String sql1 = "insert into stu (id,name,age)"
					+ " values ('6546456','¹þ¹þ',23)";

			Statement st = conn.createStatement();
			st.execute(sql);
			
			
		//	ps.execute();
			
		}  catch (SQLException e) {
			e.printStackTrace();
		}finally {
		
		}

	}

}
