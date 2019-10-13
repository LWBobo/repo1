
public class Custom {
	String name;
	String telnum;
	String id;
	Custom(String s1 , String s2 , String s3){
		this.name = s1;
		this.id = s2;
		this.telnum = s3;
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelnum() {
		return telnum;
	}
	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void buySomthing(Product s1) {
		s1.displayInof();
		System.out.println("购物已经完成！！");
	}
}