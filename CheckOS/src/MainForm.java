import java.awt.event.ActionListener;

public class MainForm {
	
	public static void action() {
		
	}
	
	
	
	public static void main(String[] args) {
		LoginForm f = new LoginForm();
		f.insert();
		Login login = new Login();
		if(login.judge(f.getAccount(), f.getPassworld())) {
			action();
		}else {
			System.out.println("输入错误！");
		}
	}
	

}
