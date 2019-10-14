package tcp.chat.theend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		System.out.println("-----Client-----");
		try {		
			Socket client = new Socket("localhost",8888);
			BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
			System.out.println(" ‰»Î√˚◊÷£∫");
			String name = br.readLine();
			new Thread(new Send(client,name)).start();
			new Thread(new Receive(client)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
