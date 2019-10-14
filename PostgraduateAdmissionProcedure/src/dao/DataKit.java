package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entity.Score;
import entity.Student;
import util.MyComparator;

public class DataKit {
static Properties pros = null;
static Score score = null;
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("scoreline_cofg.properties"));
			score = new Score(Integer.parseInt(pros.getProperty("mathscoresline")),Integer.parseInt(pros.getProperty("politicsscoresline")),
					Integer.parseInt(pros.getProperty("foreignlanguagescoresline")),Integer.parseInt(pros.getProperty("professionalbasiccoursescoresline")),
					Integer.parseInt(pros.getProperty("totalscoresline")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void changescoreline(int mathscoresline, int politicsscoresline, int foreignlanguagescoresline,
			int professionalbasiccoursescoresline, int totalscoresline) {
		if(mathscoresline>0)
			score.setMathscoresline(mathscoresline);
		if(mathscoresline>0)
			score.setPoliticsscoresline(politicsscoresline);
		if(mathscoresline>0)
			score.setForeignlanguagescoresline(foreignlanguagescoresline);
		if(mathscoresline>0)
			score.setProfessionalbasiccoursescoresline(professionalbasiccoursescoresline);
		if(mathscoresline>0)
			score.setTotalscoresline(totalscoresline);
	}
	
	public static Set<Student> selectstu(ArrayList<Student> stuarr,String type) {

			Set<Student> stuset = new TreeSet<Student>(MyComparator.getcomparator(type));
			for (int i = 0; i < stuarr.size(); i++) {
				if(stuarr.get(i).getScore().getTotalscores() >= score.getTotalscoresline()
					&& 	stuarr.get(i).getScore().getMathscores() >= score.getMathscoresline()
					&&  stuarr.get(i).getScore().getPoliticsscores() >= score.getPoliticsscoresline()
					&&  stuarr.get(i).getScore().getForeignlanguagescores() >= score.getForeignlanguagescoresline()
					&&  stuarr.get(i).getScore().getProfessionalbasiccoursescores() >= score.getProfessionalbasiccoursescoresline()
					) {
					stuset.add(stuarr.get(i));
				}
			}		
			return stuset;				
	}
	public static Set<Student> selectallstu(ArrayList<Student> stuarr) {

		Set<Student> stuset = new TreeSet<Student>(MyComparator.getcomparator("all"));
		for (int i = 0; i < stuarr.size(); i++) {	
				stuset.add(stuarr.get(i));
		}		
		return stuset;				
}

}
