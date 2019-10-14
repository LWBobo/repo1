package Entity;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -3049407726977442178L;
	private String name;
	private String passworld;
	private String sex;
	private String local;
	private String hobit;
	private String introduction;
	
	
	public User(String name, String passworld, String sex, String local, String hobit, String introduction) {
		super();
		this.name = name;
		this.passworld = passworld;
		this.sex = sex;
		this.local = local;
		this.hobit = hobit;
		this.introduction = introduction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassworld() {
		return passworld;
	}
	public void setPassworld(String passworld) {
		this.passworld = passworld;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getHobit() {
		return hobit;
	}
	public void setHobit(String hobit) {
		this.hobit = hobit;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		String info = "用户名：" + this.getName() + "\n" +
						"密码：" + this.getPassworld() + "\n" +
						"性别：" + this.getSex() + "\n" +
						"所在地：" + this.getLocal() + "\n" +
						"兴趣爱好：" + this.getHobit() + "\n" +
						"个人简介：" + this.getIntroduction();
		return info;
	}

}