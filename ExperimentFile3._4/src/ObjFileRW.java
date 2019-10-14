import java.io.*;

public class ObjFileRW{
	File file;
	
	public ObjFileRW(File file) {
		super();
		this.file = file;
	}
	public ObjFileRW(String filepath) {
		this.file = new File(filepath);
	}
	public Object read() {
		try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(this.file))){	
			try {
				return oin.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
}
	public void write(Object obj) {
		try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(this.file))){
			oout.writeObject(obj);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}