package util;

import java.util.Comparator;

import entity.Student;

public class MyComparator {
	public static Comparator<Student> getcomparator(String type){
		if(type.equals("math")) {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getScore().getMathscores() >= o2.getScore().getMathscores() ? -1:1;
					return num;
				}
			};
			return com;
		}else if(type.equals("politics")) {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getScore().getPoliticsscores() >= o2.getScore().getPoliticsscores() ? -1:1;
					return num;
				}
			};
			return com;
		}else if(type.equals("foreignlanguage")) {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getScore().getForeignlanguagescores() >= o2.getScore().getForeignlanguagescores() ? -1:1;
					return num;
				}
			};
			return com;
		}else if(type.equals("professionalbasiccourses")) {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getScore().getProfessionalbasiccoursescores() >= o2.getScore().getProfessionalbasiccoursescores() ? -1:1;
					return num;
				}
			};
			return com;
		}else if(type.equals("all")) {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getID().compareTo(o2.getID()) ;
					return num;
				}
			};
			return com;
		}else {
			Comparator<Student> com = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					int num = o1.getScore().getTotalscores() >= o2.getScore().getTotalscores() ? -1:1;
					return num;
				}
			};
			return com;
		}	
	}
	public static Comparator<Student> getcomparator(){
		Comparator<Student> com = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				int num = o1.getScore().getTotalscores() >= o2.getScore().getTotalscores() ? -1:1;
				return num;
			}
		};
		return com;
	}	
	
	}

