package clone;

import java.util.Date;


public class Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(12312321331L);
		Sheep s1 = new Sheep("多利",date);
		Sheep s2 = (Sheep) s1.clone();
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		date.setTime(23432432423L);
		
		System.out.println(s1.getBirthday());
		
		s2.setSname("少理");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
		
	}
}
