package entity;

public class Teacher extends Person {
	private String course;
	private String id ;
	private String pwd;
	


	public Teacher(String name, String sex, String course, String id, String pwd) {
		super(name, sex);
		this.course = course;
		this.id = id;
		this.pwd = pwd;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
