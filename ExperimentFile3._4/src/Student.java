import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4555966210837290014L;
	private String id;
	public Student() {}
	public Student(String name, int age) {
		super(name, age);
	}
	public Student(String name, int age, String id) {
		super(name, age);
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", getName()=" + getName() + ", getAge()=" + getAge() + "]";
	}
	public void inPutStuInof() {
		String name = null;
		int age = 0;
		String id = null;
		Scanner in = new Scanner(System.in);
		System.out.println("������name��");
		name = in.next();
		setName(name);		
		while(true) {
			System.out.println("������age��");
			age = in.nextInt();
			if(age >0 && age < 200) {
				setAge(age);
				break;
			}else {
				System.err.println("���뷶Χ�д�");
			}	
		}
		while(true) {
			System.out.println("������ID��");
			id = in.next();
			if(isNumeric(id)) {
				setId(id);
				break;
			}else {
				System.err.println("IDӦȫ��������ɵģ�");
			}
			
		}
		in.close();
	}
	public static boolean isNumeric(String str) {   

        Pattern pattern = Pattern.compile("[0-9]*");   

        Matcher isNum = pattern.matcher(str);   

        if (!isNum.matches()) {   

            return false;   

        }   

        return true;   

    }

	
}
