
public class Teacher extends People {
	private String course;

	public Teacher(String name, int age, char sex, String course) {
		super(name, age, sex);
		this.course = course;
	}

	public Teacher(String course) {
		super();
		this.course = course;
	}

	public Teacher() {
		super();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public void test(Student s) {
		s.toString();
	}
	
	public String show() {
		return ("Name:" + this.getName() +"\n"+
				"Sex:" + this.getSex() + "\n"+
				"Age:" + this.getAge() + "\n"+
				"Scurse:" + this.getCourse() + "\n");
	}
}
