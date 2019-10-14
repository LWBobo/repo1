package factory;

public class JpgReader implements ImageReader{

	@Override
	public void readimage() {
		System.out.println("读取JPG图片！");		
	}
}
