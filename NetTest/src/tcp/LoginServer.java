package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

	public static void main(String[] args) {
		System.out.println("-----Server-----");
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("客户端连接");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String mes = dis.readUTF();
			
			String[] mess = mes.split("&");
			for(String str : mess) {
				String[] info = str.split("=");
				if(info[0].equals("uname")) {
					System.out.println("name:" + info[1]);
				}else if(info[0].equals("upwd")) {
					System.out.println("pwd:" + info[1]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
