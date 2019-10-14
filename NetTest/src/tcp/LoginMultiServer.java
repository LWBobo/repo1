package tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginMultiServer {

	public static void main(String[] args) {
		System.out.println("-----Server-----");
		ServerSocket server = null;
		boolean isRunning = true;
		try {
			server = new ServerSocket(8888);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while(isRunning) {
			try {
				Socket client = server.accept();
				System.out.println("客户端连接");
				new Thread(new Channel(client)).start();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	static class Channel implements Runnable{
		private Socket client;
		private DataInputStream dis;
		private DataOutputStream dos;
		public Channel(Socket client){
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			String uname ="";
			String upwd = "";						
			String[] mess = receive().split("&");
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
			if(uname.equals("liuwenbo") && upwd.equals("123")) {
				send("登陆成功，欢迎回来！");
			}else{
				send("账号或密码错误");
			}
//			close();
			
		}
		
		private String receive() {
			String datas;
			try {
				datas = dis.readUTF();
				return datas;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "";
		}
		private void send(String mes) {
			try {
				dos.writeUTF(mes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		private void close() {
			try {
				if(null != client) {
				client.close();
				}else if(null != dis) {
				dis.close();
				}else if(null != dos) {
				dos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
