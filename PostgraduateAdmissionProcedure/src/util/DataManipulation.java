package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Score;
import entity.Student;
import fileutil.FileUtil;

public class DataManipulation {
	static Properties pros = null;
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("user_local_file.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static boolean stuinfotofile(Set<Student> stuset) {
		if(stuset == null)return false;
		StringBuffer tofile = new StringBuffer("姓名" + "\t" + "学号" + "\t\t" + "是否应届" + "\t" + "数学" + "\t" + "政治" + "\t" + "外语" + "\t" 
				+ "专业基础" + "\t" + "总分" + "\t" + "报考专业" + "\n") ;
		for(Student stu : stuset) {
			tofile.append(stu.toString() + "\n");
		}
		FileUtil.filewiter(tofile.toString());
		return true;
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
	
	public static boolean changestuinfoindb(Student stu,String oldid) {
		Connection conn = JDBCutil.getMysqlConn();
		PreparedStatement pst = null;
		Student oldstu = null;
		ResultSet rs = null;
		try {
			
				String sql = "select * from  stu_info where id=" + oldid;
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				while(rs.next()) {
					Score score = new Score(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
					oldstu = new Student(rs.getString(2), rs.getInt(4), rs.getString(3), rs.getString(1), score, rs.getString(10),rs.getString(11));
				}
				if(!oldstu.getName().equals(stu.getName())) {
					 sql = "update stu_info set name=" + "'" +stu.getName() + "'"+ " where id =" +oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getAge() !=(stu.getAge())) {
					sql = "update stu_info set age=" + stu.getAge() + " where id =" +oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(!oldstu.getCurrent().equals(stu.getCurrent())) {
					sql = "update stu_info set current=" + "'"+ stu.getCurrent() + "'"+ " where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(!oldstu.getSex().equals(stu.getSex())) {
					sql = "update stu_info set sex=" + "'"+ stu.getSex() + "'"+ " where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(!oldstu.getApplyingmajor().equals(stu.getApplyingmajor())) {
					sql = "update stu_info set applyingmajor= " + "'"+ stu.getApplyingmajor() + "'"+ "where id = " + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getScore().getMathscores() != stu.getScore().getMathscores()) {
					sql = "update stu_info set mathscores= " + stu.getScore().getMathscores()  + " where id = " + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getScore().getPoliticsscores() != stu.getScore().getPoliticsscores()) {
					sql = "update stu_info set politicsscores= " +  stu.getScore().getPoliticsscores() + " where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getScore().getForeignlanguagescores() != stu.getScore().getForeignlanguagescores()) {
					sql = "update stu_info set foreignlanguagescores= " + stu.getScore().getForeignlanguagescores() + " where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getScore().getProfessionalbasiccoursescores() != stu.getScore().getProfessionalbasiccoursescores()) {
					sql = "update stu_info set professionalbasiccoursescores= " + stu.getScore().getProfessionalbasiccoursescores() + " where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
				if(oldstu.getScore().getTotalscores() != stu.getScore().getTotalscores()) {
					sql = "update stu_info set totalscores= " + stu.getScore().getTotalscores() + " where id =" +oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}		
				if(!oldstu.getID().equals(stu.getID()) && !stu.getID().equals("")) {
					sql = "update stu_info set id=" + "'" + stu.getID()+ "'" + "where id =" + oldid;
					 Statement st = conn.createStatement();
					 st.execute(sql);
				}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
				JDBCutil.close(pst);
				JDBCutil.close(conn);	
	}
}
	public static boolean isLeagleId(String str) {   

        Pattern pattern = Pattern.compile("[0-9]*");   

        Matcher isNum = pattern.matcher(str);   

        if (!isNum.matches()) {   

            return false;   
        }   
        if(str.length() != 12) {
        	return false;
        }

        return true;   
    }
	public static boolean isLeagleScore(String str) {   

        Pattern pattern = Pattern.compile("[0-9]*");   

        Matcher isNum = pattern.matcher(str);   

        if (!isNum.matches()) {   

            return false;   
        }   
        if(str.length() > 3) {
        	return false;
        }
        return true;   
    }
}
