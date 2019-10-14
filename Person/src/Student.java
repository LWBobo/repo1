
public class Student extends People {
	private String ID;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, char sex) {
		super(name, age, sex);
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, char sex, String iD) {
		super(name, age, sex);
		this.ID = iD;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String show() {
		return ("Name:" + this.getName() +"\n"+
				"Sex:" + this.getSex() + "\n"+
				"Age:" + this.getAge() + "\n"+
				"ID:" + this.getID()+"\n");
	}
	
}
