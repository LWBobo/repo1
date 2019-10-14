
public class People {
	private String name;
	private int age;
	private char sex;
	
	
	public People() {}
	public People(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String show() {
		return ("Name:" + this.getName() +"\n"+
				"Sex:" + this.getSex() + "\n"+
				"Age:" + this.getAge() + "\n");
	}
	
}
