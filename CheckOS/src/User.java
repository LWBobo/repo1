
public class User {
	private String name;
	private String pwd;
	private String sex;
	private String add;
	private int age;
	
	public User() {
	}
	public User(String name, String pwd, String sex, String add, int age) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.add = add;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
