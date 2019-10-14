package loc;

import java.io.*;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.tmall.com");
			InputStream is = url.openStream();
//		OutputStream os = new FileOutputStream(new File("G:\1.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("G:/1.txt")));
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			String str = null;
			while(null != (str = br.readLine())) {
				System.out.println(str);
				bw.write(str);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
