package tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginMultiClient {

	public static void main(String[] args) {
		System.out.println("-----Client-----");
		try {
			
			Socket client = new Socket("localhost",8888);
			
			new Send(client).send();
			new Receive(client).receive();
					
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static class Send{
		private DataOutputStream dos;
		private Socket client;
		BufferedReader br;
		private Send(Socket client) {
			this.client = client;
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				dos = new DataOutputStream(client.getOutputStream());
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void send() {
			try {
				dos.writeUTF(init());
				if(null != dos) {
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		private String init() {
			String uname;
			String upwd;
			try {
				System.out.println("请输入用户名：");
				uname = br.readLine();
				System.out.println("请输入密码：");
				upwd = br.readLine();
				return "uname=" + uname +"&" + "upwd=" + upwd;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}
		}
		
	
	static class Receive {
		private DataInputStream dis ;
		private Socket client;
		private Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		private void receive() {
			String mes = null;
			try {
				mes = dis.readUTF();
				System.out.println(mes);	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
