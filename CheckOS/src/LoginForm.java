import java.util.Scanner;

class LoginForm {
	private String account;
	private String passworld;
	public  void insert() {
		Scanner s = new Scanner(System.in);
		account = s.nextLine();
		passworld = s.next();
	}
	public  String getAccount() {
		return account;
	}
	public  String getPassworld() {
		return passworld;
	}
	
}
