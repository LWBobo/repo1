package tcp.chat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chat {
	public static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Chat.Channel>();
	public static void main(String[] args) {
		System.out.println("-----Server-----");
		ServerSocket server;
		try {
			server = new ServerSocket(8888);
			while(true) {
			Socket client = server.accept();
			Channel c = new Channel(client);
			System.out.println("客户端连接");
			all.add(c);
			new Thread(c).start();
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean isRunning;
		private String name; 
		public Channel(Socket client) {
			try {
				this.client = client;
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream()); 
				this.name = receive();
				isRunning = true;
				send("欢迎进入聊天室！");
				sendothers(name + "加入了聊天室！", true);
			} catch (IOException e) {
				System.out.println("-----make-----");
				release();
			}
			
		}
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
				return msg;
			} catch (IOException e) {
				System.out.println("-----receive-----");
				release();
			}
			
			return msg;
		}
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				System.out.println("-----send-----");
				release();
			}
		}
		private void sendothers(String msg , boolean isSys) {
		
				for(Channel other : all) {
					if(other == this) {
						continue;
					}else {
						if(!isSys) {
							other.send(name + ":" +msg);
						}else {
							other.send("系统消息:" +msg);
						}
					}
				}
			
		}
		private void release() {
			this.isRunning = false;
			ChatUtils.close(dis,dos,client);
			all.remove(this);
			sendothers(name + "离开了群聊...", true);
		}
		@Override
		public void run() {
		while(isRunning) {
			String msg = receive();
			if(!msg.equals("")) {
				sendothers(msg,false);
			}
		}
		}
		
		
	}
	
	
	
	
	
	
	
	
}
