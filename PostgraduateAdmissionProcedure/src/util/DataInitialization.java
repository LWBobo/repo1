package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DataInitialization {
	static Properties pros = null;
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("user_local_file.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean initteacher() {
		Connection conn = JDBCutil.getMysqlConn();
		PreparedStatement pst = null;
		FileReader fr = null;
		BufferedReader bfr = null;
		try {
			{
				String sql = "delete  from  teacher_info where 1=1";
				pst = conn.prepareStatement(sql);
				pst.executeUpdate();
			}

			fr = new FileReader(new File(pros.getProperty("teacher_info")));
			bfr = new BufferedReader(fr);
			String str = null;
			int i = 1001;
			while ((str = bfr.readLine()) != null) {
				String[] arr = str.split(" ");
				String sql = "insert into teacher_info (id,name,sex,course,pwd) values (?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, "1771" + i);
				pst.setString(2, arr[0]);
				pst.setString(3, arr[1]);
				String temp = "";
				for (int j = 2; j < arr.length; j++) {
					temp += arr[j] + " ";
				}
				pst.setString(4, temp);
				pst.setString(5, "1771" + i);
				i++;
				pst.execute();
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				bfr.close();
				fr.close();
				JDBCutil.close(pst);
				JDBCutil.close(conn);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static boolean initstudent() {
		Connection conn = JDBCutil.getMysqlConn();
		PreparedStatement pst = null;
		FileReader fr = null;
		BufferedReader bfr = null;
		try {
			{
				String sql = "delete  from  stu_info where 1=1";
				pst = conn.prepareStatement(sql);
				pst.executeUpdate();
			}

			fr = new FileReader(new File(pros.getProperty("student_info")));
			bfr = new BufferedReader(fr);
			String str = null;
			while ((str = bfr.readLine()) != null) {
				String[] arr = str.split(",");
				if (arr[0].toString().equals( "学号")){
					continue;
					}
				String sql = "insert into stu_info (id,name,sex,age,mathscores,politicsscores,foreignlanguagescores,professionalbasiccoursescores,totalscores,current,applyingmajor)"
						+ " values (?,?,?,?,?,?,?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, arr[0]);
				pst.setString(2, arr[1]);
				pst.setString(3, arr[2]);
				pst.setInt(4, Integer.parseInt(arr[3].toString()));
				pst.setInt(5, Integer.parseInt(arr[4]));
				pst.setInt(6, Integer.parseInt(arr[5]));
				pst.setInt(7, Integer.parseInt(arr[6]));
				pst.setInt(8, Integer.parseInt(arr[7]));
				pst.setInt(9, Integer.parseInt(arr[8]));
				pst.setString(10, arr[9]);
				pst.setString(11, arr[10]);
				pst.execute();
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				bfr.close();
				fr.close();
				JDBCutil.close(pst);
				JDBCutil.close(conn);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
