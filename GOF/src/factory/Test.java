package factory;

public class Test {
	public static void main(String[] args) {
		ImageReader reader1 = new GifReaderFactory().createimagereader();
		ImageReader reader2 = new JpgReaderFactory().createimagereader();
		reader1.readimage();
		reader2.readimage();
		
	}
}
