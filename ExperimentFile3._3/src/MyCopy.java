import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;

public class MyCopy {
	private File file;
	private String fFilePath;
	private String tFilePath;

	public MyCopy(File file) {
		super();
		this.file = file;
		fFilePath = this.file.getAbsolutePath();
	}
	public MyCopy() {
		super();
	}
	public static File choicefFile() {
		JFileChooser jc = new JFileChooser();
		jc.setDialogTitle("ѡ��Ҫ���Ƶ��ļ����ļ���");
		jc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jc.setCurrentDirectory(new File("c:/"));
		int value = jc.showSaveDialog(null);
		if (value == JFileChooser.APPROVE_OPTION) {
            return jc.getSelectedFile();
        } else {
            System.err.println("δѡ���ļ����ļ��У�");
            return null;
        }
	}
	public static String choicetFileDir(){
		JFileChooser jc = new JFileChooser();
		jc.setDialogTitle("ѡ��Ŀ���ļ���");
		jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jc.setCurrentDirectory(new File("c:/"));
		int value1 = jc.showSaveDialog(null);
		if (value1 == JFileChooser.APPROVE_OPTION) {
            return jc.getSelectedFile().getAbsolutePath();
        } else {
            System.err.println("δѡ���ļ��У�");
            return null;
        }
	}
	
	public boolean copy(String tFilepath) {
		this.tFilePath = tFilepath;
		if(this.file.getAbsolutePath().equals(this.tFilePath)) {
			System.err.println("��ͬĿ¼�޷����ƣ�");
			return false;
		}
		if (!this.file.exists()) {
			System.err.println("�ļ������ڣ�");
			return false;
		} else if (this.file.isDirectory()) {
			File file1 = new File(this.tFilePath + "/" + this.file.getName());    //Ŀ���ļ�
			file1.mkdir();      //����Ŀ��Ŀ¼һ���ļ���
			String [] str = this.file.list();
			for (int i = 0; i < str.length; i++) {
				File file2 = new File(this.fFilePath +  "/" + str[i]);
				String s1 = tFilePath + "/" + file.getName();
				MyCopy mycopy = new MyCopy(file2);
				mycopy.copy(s1);			
			}
			return true;
		} else if (this.file.isFile()) {
			String tFilePath = this.tFilePath;
			this.tFilePath = tFilePath + "/" + this.file.getName();
			byte[] b = new byte[1024];
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

	public void show() {
		System.out.println("From:" + this.file.getAbsolutePath());
		System.out.println("To:" + this.tFilePath);
	}
	
	
}