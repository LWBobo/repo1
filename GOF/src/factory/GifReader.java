package factory;

public class GifReader implements ImageReader{

	@Override
	public void readimage() {
		System.out.println("读取GIF图片！");
		
	}
}
