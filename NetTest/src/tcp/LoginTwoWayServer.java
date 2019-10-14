package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTwoWayServer {

	public static void main(String[] args) {
		System.out.println("-----Server-----");
		try {
			ServerSocket server = new ServerSocket(8888);
			Socket client = server.accept();
			System.out.println("客户端连接");
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String uname ="";
			String upwd = "";			
			
			String mes = dis.readUTF();
			String[] mess = mes.split("&");
			for(String str : mess) {
				String[] info = str.split("=");
				if(info[0].equals("uname")) {
					System.out.println("name:" + info[1]);
					uname = info[1];
				}else if(info[0].equals("upwd")) {
					System.out.println("pwd:" + info[1]);
					upwd =  info[1];
				}
			}
			
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			if(uname.equals("liuwenbo") && upwd.equals("123")) {
				dos.writeUTF("登陆成功，欢迎回来！");
			}else{
				dos.writeUTF("账号或密码错误");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
