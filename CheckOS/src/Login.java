import java.util.ArrayList;
import java.util.Scanner;

public class Login {
	private ArrayList<User> user;
	User u = new User();

	public Login() {
		user = new ArrayList<User>();
	}
	
	public boolean judge(String acc , String pwd) {
		for(int i = 0 ; i < user.size() ; ++i) {
			if(user.get(i).getName().equals(acc) && 
					user.get(i).getName().equals(pwd)){
				return true;
			}
		}
		
		return false;
	}

}
