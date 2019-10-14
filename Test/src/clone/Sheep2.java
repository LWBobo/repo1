package clone;

import java.util.Date;



public class Sheep2 implements Cloneable {   //1997,鑻卞浗鐨勫厠闅嗙緤锛屽鍒╋紒
	private String sname;
	private Date birthday;
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();  //鐩存帴璋冪敤object瀵硅薄鐨刢lone()鏂规硶锛�
		
		
		//娣诲姞濡備笅浠ｇ爜瀹炵幇娣卞鍒�(deep Clone)
		Sheep2 s = (Sheep2) obj;
		s.birthday = (Date) this.birthday.clone();  //鎶婂睘鎬т篃杩涜鍏嬮殕锛�
		
		return obj;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Sheep2(String sname, Date birthday) {
		super();
		this.sname = sname;
		this.birthday = birthday;
	}
	
	public Sheep2() {
	}
	
}
