package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		System.out.println("-----Server-----");
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("客户端连接");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String mes = dis.readUTF();
			System.out.println(mes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
