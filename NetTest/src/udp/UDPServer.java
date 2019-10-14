package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class UDPServer {
	public static void main(String[] args) {
		System.out.println("接收方启动中....");
		try {
			DatagramSocket server = new DatagramSocket(9999);
			byte[] container = new byte[1024*60];
			DatagramPacket packet = new DatagramPacket(container, 0,container.length);
			server.receive(packet);
			byte[] datas = packet.getData();
			System.out.println(new String(datas));
			server.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
	}

}
