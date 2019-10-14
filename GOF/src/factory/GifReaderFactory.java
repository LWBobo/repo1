package factory;

public class GifReaderFactory implements ImageReaderFactory{

	@Override
	public ImageReader createimagereader() {
		return new GifReader();
	}

}
