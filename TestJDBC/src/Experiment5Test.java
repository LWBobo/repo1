import java.sql.Connection;

import util.JDBCutil;

public class Experiment5Test {

	public static void main(String[] args) {
		Connection conn = JDBCutil.getMysqlConn();
		Experiment5 operasql = new Experiment5(conn);
//		
//		for (int i = 0; i <50; i++) {
//			Student stu = new Student("zhangsan"+i, 18, 'm', "2017160401"+i);
//			operasql.add(stu);
//		}
//		operasql.add(stu);
//		operasql.dispAll();
		
		
//		if(operasql.findById("201716040111")) {
//			
//		}else {
//			System.out.println("Î´ÕÒµ½£¡");
//		}
		
		
//		if(operasql.findByName("zhangsan1")) {
//			
//		}else {
//			System.out.println("Î´ÕÒµ½£¡");
//		}
		int count = operasql.delById("201716040114");
		if(count == 0) {
			System.out.println("É¾³ýÊ§°Ü£¡");
		}else if(count == 1) {
			System.out.println("É¾³ý³É¹¦£¡");
		}

}
}