import java.io.File;

public class MyCopyTest {

	public static void main(String[] args) {
		String path1 = "F:/QQ����/����ʷ��ҵ.txt";
		String path2 = "D:";
		File file = new File(path1);
		MyCopy mycopy = new MyCopy(file);
		mycopy.copy(path2);

	}

}
