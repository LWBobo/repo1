
public class Cat extends Pet {
	private String colar;
	
	public Cat(String name, int age, char sex, String colar) {
		super(name, age, sex);
		this.colar = colar;
	}

	public String getColar() {
		return colar;
	}

	public void setColar(String colar) {
		this.colar = colar;
	}
	public void show() {
		System.out.println("Name:" + this.getName() +"\n"+
							"Age:" + this.getAge() + "\n"+
							"Sex" + this.getSex()+"\n"+
							"Color:" + this.getColar());
	} 
	public void shout(){
		System.out.println("ίχίχίχ");
		
	}

}
