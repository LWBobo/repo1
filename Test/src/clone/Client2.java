package clone;

import java.util.Date;

/**
 * 原型模式(深复�?)
 * @author 尚学堂高淇www.sxt.cn
 *
 */
public class Client2 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Date date = new Date(12312321331L);
		Sheep2 s1 = new Sheep2("����",date);
		Sheep2 s2 = (Sheep2) s1.clone();   //实现深复制�?�s2对象的birthday是一个新对象�?
		
		
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		date.setTime(23432432423L);
		
		System.out.println(s1.getBirthday());
		
		
		s2.setSname("����");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
		
		
		
	}
}
