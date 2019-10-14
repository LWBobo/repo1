import java.io.File;
import java.io.FilenameFilter;

public class FileFilterDemo {

	public static void main(String[] args) {
		final String filepath = "src/สตั้3/Debugging";
		File file = new File(filepath);
		String [] filelist = file.list(new MyFliter("cpp"));
		for (int i = 0; i < filelist.length; i++) {
			System.out.println(filelist[i]);
		}

	}

	
	static class MyFliter implements FilenameFilter {
		private String ext;
		
		public MyFliter(String ext) {
			super();
			this.ext = ext;
		}

		@Override
		public boolean accept(File dir, String name) {
			
				if(name.endsWith(this.ext))
					return true;
				else
					return false;
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
