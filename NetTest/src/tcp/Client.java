package tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		System.out.println("-----Client-----");
		try {
			Socket client = new Socket("localhost",8888);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			String data = "Hello";
			dos.writeUTF(data);
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
