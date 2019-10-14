
public class PersonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People hum1 = new People("Xiaoming",15,'m');
		Student stu1 = new Student("Xiaowang",16,'m',"20171604001");
		Teacher teac1 = new Teacher("Mrs.Dind",35,'f',"English");
		System.out.println(hum1.show());
		System.out.println(stu1.show());
		System.out.println(teac1.show());
	}

}
