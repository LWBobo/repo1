import java.io.File;
import java.io.FilenameFilter;

public class MyFileFliter {

	public static void main(String[] args) {
		String filepath = "E:/QQ����";
		File file = new File(filepath);
		String [] str = file.list();
		System.out.println("ɸѡǰ��");
		for(String s : str) {
			System.out.println(s);
		}
		String []str1 = file.list(new Myfilefliter("docx"));
		System.out.println("ɸѡ��");
		for(String s :str1) {
			System.out.println(s);
		}

	}
	
	static class Myfilefliter implements FilenameFilter{
		private String dex;
		

		public Myfilefliter(String dex) {
			super();
			this.dex = dex;
		}


		@Override
		public boolean accept(File dir, String name) {
			if(name.endsWith(this.dex)) {
				return true;
			}
			return false;
		}
		
	}
	

}
