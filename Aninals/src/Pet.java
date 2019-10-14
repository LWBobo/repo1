
public class Pet {
	private String name;
	private int age;
	private char sex;
	
	public Pet(String name, int age, char sex) {
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
	public void show() {
		System.out.println("Name:" + this.getName() +"\n"+
							"Age:" + this.getAge() + "\n"+
							"Sex" + this.getSex());
	}
	public void shout(){
		System.out.println("·¢³öºðÉù£¡£¡£¡£¡");
		
	}
	
}
