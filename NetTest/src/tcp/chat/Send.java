package tcp.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	private BufferedReader br;
	private DataOutputStream dos;
	private Socket client;
	private boolean isRunning;
	private String name;
	
	public Send(Socket client,String name) {
		this.client = client;
		this.name = name;
		br  = new BufferedReader(new InputStreamReader(System.in));
		try {
			dos = new DataOutputStream(client.getOutputStream());
			isRunning = true;
			send(name);
		} catch (IOException e) {
			System.out.println("-----make-----");
		} 
	}
	private String getStrFromConsole() {
		try {
			return br.readLine();
		} catch (IOException e) {
			System.out.println("-----input-----");
			 release();
		}
		return "";
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
	private void release() {

		ChatUtils.close(dos,client);
	}
	@Override
	public void run() {
		while(isRunning) {
			String msg = getStrFromConsole();
			if(!msg.equals("")) {
				send(msg);
			}
			
		}
	}

}
