package udp.talk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Send implements Runnable{
	
	private int port;
	private String to_IP;
	private int to_port;
	private BufferedReader bfr;
	private DatagramSocket client ;
	
	public Send(int port, String toip , int toport) {
		this.port = port;
		this.to_IP = toip;
		this.to_port = toport;
		try {
			this.client = new DatagramSocket(this.port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		bfr = new BufferedReader(new InputStreamReader(System.in));
	}
	@Override
	public void run() {
		try {
			while(true) {
				String data = bfr.readLine();
//				System.out.println(data);
				byte[] datas = data.getBytes();
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length
						,new InetSocketAddress(to_IP, to_port));
				client.send(packet);
				if(data.equals("bye")) {
					break;
				}
			}
			client.close();
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	

}
