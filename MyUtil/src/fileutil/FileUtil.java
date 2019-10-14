package fileutil;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;

public class FileUtil {
	public static void filewiter(String str){
		String path = null;
		FileDialog filedialog = new FileDialog( new Frame(),"请选择", FileDialog.SAVE);
		filedialog.setVisible(true);
		path = filedialog.getDirectory();
		String name = null;
		if(path != null) {
			name = filedialog.getFile();
		}	
		try(FileWriter fw = new FileWriter(new File(path + "/" + name));
			BufferedWriter bfw = new BufferedWriter(fw)
				){
			bfw.write(str.replaceAll("\n", "\r\n"));
			
		} catch (Exception e2) {
		}	
	}

}
