package udp.talk;

public class Teacher {

	public static void main(String[] args) {
		System.out.println("Teacher");
		new Thread(new Receive(9999,"ÎÄå«")).start();
		new Thread(new Send(7777, "localhost", 6666)).start();
	}

}
