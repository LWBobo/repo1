package udp.talk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive implements Runnable{
	
	private int port;
	private DatagramSocket server;
	String from;
	
	
	 public Receive(int port,String from) {
		this.from = from;
		this.port = port;
		try {
			this.server = new DatagramSocket(this.port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	 
	@Override
	public void run() {
		
		while(true) {
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container, 0,container.length);
			try {
				server.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			byte[] datas = packet.getData();
			int len = packet.getLength();
			String str = new String(datas,0,len);
			System.out.println(from + ":" + str);
			if(str.equals("bye")) {
				break;
			}
		}
		server.close();
	
	}
}
