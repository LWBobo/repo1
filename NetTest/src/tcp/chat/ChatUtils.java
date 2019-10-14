package tcp.chat;

import java.io.Closeable;
import java.io.IOException;

public class ChatUtils {
	
	public static void close(Closeable ... targets) {
		for(Closeable target : targets) {
			try {
				if(null != target) {
					target.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
