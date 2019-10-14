package tcp.chat.theend;

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
	
	public static String arrToString(String []str) {
		StringBuffer bf = new StringBuffer();
		for(int i = 1 ; i < str.length ; ++i) {
			bf.append(str[i]);
		}
		return bf.toString();
		
	}

}
