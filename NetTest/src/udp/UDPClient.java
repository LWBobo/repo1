package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPClient {
	public static void main(String[] args) {
		System.out.println("���ͷ�������....");
		try {
			DatagramSocket client = new DatagramSocket(8888);
			String data = "���Ϲ�ҵ��ѧ������";
			byte[] datas = data.getBytes();
			DatagramPacket packet = new DatagramPacket(datas, 0, datas.length
					,new InetSocketAddress("localhost", 9999));
			client.send(packet);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
