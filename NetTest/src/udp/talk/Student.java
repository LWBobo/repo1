package udp.talk;

public class Student {

	public static void main(String[] args) {
		System.out.println("ÎÄå«");
		new Thread(new Send(8888, "localhost", 9999)).start();
		new Thread(new Receive(6666,"Teacher")).start();

	}

}
