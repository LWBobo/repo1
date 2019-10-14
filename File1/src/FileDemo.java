import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		
		readFile("src");
		
}

public static void readFile(String filepat){
	final String filepath = filepat;
	File file = new File(filepath);
	String []str = file.list();
	for(int i = 0 ; i < str.length ; ++i){
		File file1 = new File(filepath + "/"+str[i]);
		if(file1.isFile()){
			System.out.println(str[i] + "  -文件大小：" + file1.length()/1024 + "kb");
		}
		else if(file1.isDirectory()){
			System.out.println("");
			System.out.println(str[i] + "  -文件夹" );
			readFile(filepath + "/" + str[i]);
		}
		
	}

}
	
}



