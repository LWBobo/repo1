package udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPTalkClient {
	public static void main(String[] args) {
		System.out.println("���ͷ�������....");
		try {
			DatagramSocket client = new DatagramSocket(8888);
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			while(true) {
				
				String data = bfr.readLine();
				System.out.println("����-->" + data);
				byte[] datas = data.getBytes();
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length
						,new InetSocketAddress("localhost", 9999));
				client.send(packet);
				if(data.equals("bye")) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
