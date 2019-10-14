package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginTwoWayClient {

	public static void main(String[] args) {
		System.out.println("-----Client-----");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入用户名：");
			String uname = br.readLine();
			System.out.println("请输入密码：");
			String upwd = br.readLine();
			
			Socket client = new Socket("localhost",8888);
			DataOutputStream dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF("uname=" + uname +"&" + "upwd=" + upwd);
			
			DataInputStream dis = new DataInputStream(client.getInputStream());
			String mes = dis.readUTF();
			System.out.println(mes);
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
