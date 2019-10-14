package entity;

public class Student extends Person {
	private String ID;
	private Score score ;
	private String current;
	private String applyingmajor;
	public Student(String name, int age, String sex, String iD, Score score, String current,String applyingmajor) {
		super(name, age, sex);
		ID = iD;
		this.score = score;
		this.current = current;
		this.applyingmajor = applyingmajor;
	}
	public Student(String iD, Score score, String current) {
		super();
		ID = iD;
		this.score = score;
		this.current = current;
	}
	public Student() {
		super();
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	
	public String getApplyingmajor() {
		return applyingmajor;
	}
	public void setApplyingmajor(String applyingmajor) {
		this.applyingmajor = applyingmajor;
	}
	@Override
	public String toString() {
		String str = this.getName() + "\t" + this.getID() + "\t" + this.getCurrent() + "\t"
						+ this.getScore().toString() +"\t" + this.getApplyingmajor();
		return str;
	}
}
