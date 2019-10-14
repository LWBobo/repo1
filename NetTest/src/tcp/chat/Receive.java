package tcp.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	private DataInputStream dis;
	private Socket client;
	private boolean isRunning;
	 public Receive(Socket client) {
		 this.client = client;
		 try {
			dis = new DataInputStream(client.getInputStream());
			isRunning = true;
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
	 private void release() {
		 	isRunning = false;
			ChatUtils.close(dis,client);
		}
	
	@Override
	public void run() {
		while(isRunning) {
			String msg;
				msg = receive();
				if(!msg.equals("")) {
					System.out.println(msg);
				
				}
			}
	}

}
