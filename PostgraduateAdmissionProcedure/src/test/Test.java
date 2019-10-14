package test;
import java.util.*;
import dao.DataKit;
import dao.DbRead;
import entity.Student;
import entity.Teacher;
import fileutil.FileUtil;
import gui.ChangeStuInfo;
import gui.LogIn;
import gui.MainFrame;
import util.DataManipulation;

public class Test {

	public static void main(String[] args) {
//		DataManipulation.initteacher();
//		DataManipulation.initstudent();
		ArrayList<Student> stuarr =null;
		ArrayList<Teacher> tea = null;
		stuarr = DbRead.readstuinfo();
		tea = DbRead.readteacherinfo();
		new LogIn(tea,stuarr);
//		new MainFrame(7, tea, stuarr);
//		new ChangeStuInfo(stuarr);
		
	}

}
