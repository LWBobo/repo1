package factory;

public class JpgReaderFactory implements ImageReaderFactory{
	@Override
	public ImageReader createimagereader() {
		return new JpgReader();
	}
}
