package loc;

import java.net.*;

public class IpTest {

	public static void main(String[] args) {

		try {
			InetAddress add = InetAddress.getLocalHost();
			System.out.println(add.getHostAddress());
			System.out.println(add.getHostName());
			add = InetAddress.getByName("www.baidu.com");
			System.out.println(add.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
