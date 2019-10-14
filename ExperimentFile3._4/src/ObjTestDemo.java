import java.io.*;


public class ObjTestDemo {

	public static void main(String[] args) {
		File file = new File("G:/JAVASpace/ExperimentFile3._4/src/data/stuData.dat");
		ObjFileRW of = new ObjFileRW(file);
		Student stu = new Student();
		 stu.inPutStuInof();
		 of.write(stu);
		 Student stu1 = (Student)of.read();
		 System.out.println("stu:" + stu.toString());
		 System.out.println("stu1:" + stu1.toString());
	}
	
}
