import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MyCopy {
	private File file;
	private String fFilePath;
	private String tFilePath;

	public MyCopy(File file) {
		super();
		this.file = file;
		fFilePath = this.file.getAbsolutePath();
	}

	public boolean copy(String tFilepath) {
		if (!this.file.exists()) {
			System.out.println("文件不存在！");
			return false;
		} else if (this.file.isDirectory()) {
			this.tFilePath = tFilepath + "/" + this.file.getName();
			File file = new File(this.tFilePath);
			file.mkdir();
			
			
		} else if (this.file.isFile()) {
			this.tFilePath = tFilepath + "/" + this.file.getName();
			byte[] b = new byte[100];
			int num = 0;
			try (InputStream in = new FileInputStream(this.file);
					BufferedInputStream bin = new BufferedInputStream(in);
					OutputStream out = new FileOutputStream(this.tFilePath);
					BufferedOutputStream bout = new BufferedOutputStream(out)) {
				while ((num = bin.read(b)) != -1) {
					bout.write(b);
				}
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return false;
		}
	return false;
	}

}
