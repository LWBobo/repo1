import java.io.File;

public class MyCopyTest {

	public static void main(String[] args) {
		String path1 = "F:/QQ接收/近代史作业.txt";
		String path2 = "D:";
		File file = new File(path1);
		MyCopy mycopy = new MyCopy(file);
		mycopy.copy(path2);

	}

}
